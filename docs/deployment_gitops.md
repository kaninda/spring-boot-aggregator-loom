# 🚀 Déploiement GitOps avec Argo CD

Ce document décrit comment les microservices du projet spring-boot-aggregator-loom sont déployés sur Kubernetes en utilisant Argo CD, Helm et une approche GitOps.

---

## 🧠 Principe du GitOps

Le déploiement repose sur un principe simple:

**Git est la source de vérité pour l’état désiré du cluster.**

Argo CD lit :
- les ressources Application depuis le repository bootstrap
- les charts Helm depuis le repository applicatif

et s’assure que le cluster Kubernetes reflète cet état.

Toute modification du système passe par:

- un commit Git
- une synchronisation Argo CD

---

## 🏗️ Architecture de déploiement

````mermaid
flowchart TD
    A[Developer pushes code] --> B[GitHub]
    B --> C[GitHub Actions CI]
    C --> D[Build + Tests]
    D --> E[Build container images]
    E --> F[Push to GHCR]
    F --> T[Update Helm Values or
    image tag in Git ]
    T --> G[Git repository containing
    deployment config]
    G --> H[Argo CD]
    H --> I[Kubernetes Cluster]

    I --> J[user-service]
    I --> K[order-service]
    I --> L[loyalty-service]
    I --> M[aggregator-service]
````

---
## structure des repos
````shell
gitops-cluster-bootstrap/
├── argocd/
├── apps/
├── projects/
└── rbac/

spring-boot-aggregator-loom/
├── user-service/
├── order-service/
├── loyalty-service/
├── aggregator-service/
└── deploy/
    └── helm/
````
- **gitops-cluster-bootstrap** contient le bootstrap ArgoCD et les Application
- **spring-boot-aggregator-loom**  contient:
    - le code source
    - les charts Helm
---


## 📦 Composants du déploiement

### 1. Images container
Chaque microservice produit une image:

````shell
ghcr.io/kaninda/<service>:<version>
````

Exemple :

````shell
ghcr.io/kaninda/user-service:1.0.5-snapshot
````
---

### 2. Charts Helm
Chaque service est déployé via un chart Helm:
````shell
deploy/helm/
├── user-service/
├── order-service/
├── loyalty-service/
└── aggregator-service/
````
Chaque chart contient :
````shell
Chart.yaml
values.yaml
values-dev.yaml
templates/
````
---

### 3. Applications Argo CD

Chaque microservice correspond à une Application Argo CD:

````yaml
spec:
  source:
    repoURL: git@github.com:kaninda/spring-boot-aggregator-loom.git
    path: deploy/helm/user-service
    targetRevision: master
````
---

### 4. Namespaces
Chaque service est isolé dans son namespace:
````shell
user-service-dev
order-service-dev
loyalty-service-dev
aggregator-service-dev
````
Création automatique:

````yaml
syncOptions:
  - CreateNamespace=true
````

---
## 🔄 Flux de déploiement

### Étapes complètes

````mermaid
flowchart TD
    A[Push code] --> B[CI build]
    B --> C[Build images]
    C --> D[Push to GHCR]

    D --> E[Update Helm values]
    E --> F[Commit Git]

    F --> G[Argo CD detects change]
    G --> H[Helm template]
    H --> I[Apply to Kubernetes]
````

---

## ⚙️ Configuration Argo CD
### Exemple d’Application
````yaml
apiVersion: argoproj.io/v1alpha1
kind: Application
metadata:
  name: user-service-dev
  namespace: argocd
spec:
  project: spring-boot-aggregator-loom-project
  source:
    repoURL: git@github.com:kaninda/spring-boot-aggregator-loom.git
    path: deploy/helm/user-service
    targetRevision: master
    helm:
      valueFiles:
        - values-dev.yaml
  destination:
    server: https://kubernetes.default.svc
    namespace: user-service-dev
  syncPolicy:
    automated:
      prune: true
      selfHeal: true
    syncOptions:
      - CreateNamespace=true
````

---

## 🔁 Synchronisation automatique

Argo CD est configuré en mode automatique:

````yaml
syncPolicy:
  automated:
    prune: true
    selfHeal: true
````
### Effets:
- 🔄 déploiement automatique après commit
- 🧹 suppression des ressources supprimées dans Git
- 🔧 correction automatique du drift

---

## 🎯 Ordre de déploiement (sync-wave)

Les ressources sont déployées dans un ordre contrôlé:

| Wave | Description                           |
| ---- | ------------------------------------- |
| -1   | AppProject                            |
| 0    | Applications ArgoCD des microservices |


Exemple:

````yaml
metadata:
  annotations:
    argocd.argoproj.io/sync-wave: "1"
````

---

## 📈 Résultat

Une fois déployé :

- chaque service tourne dans son namespace
- les images sont versionnées
- le cluster est synchronisé avec Git
