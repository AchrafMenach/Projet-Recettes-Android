# 📱 Projet Recettes Android

Une application Android native permettant de gérer vos recettes de cuisine avec les opérations CRUD complètes (Créer, Lire, Modifier, Supprimer).

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=for-the-badge)

## 📋 Sommaire

- [Aperçu](#aperçu)
- [Fonctionnalités](#fonctionnalités)
- [Captures d'écran](#captures-décran)
- [Architecture](#architecture)
- [Installation](#installation)
- [Utilisation](#utilisation)
- [Données et persistance](#données-et-persistance)
- [Limitations](#limitations)
- [Roadmap](#roadmap)
- [Contribuer](#contribuer)
- [Licence](#licence)

## 🎯 Aperçu

Application CRUD de recettes fonctionnant hors-ligne avec navigation par Intent entre cinq écrans principaux. La liste des recettes se met automatiquement à jour grâce à la méthode `onResume()` et un adapter notifié.

### Écrans disponibles :
- **Accueil** : Navigation vers les fonctionnalités principales
- **Ajout** : Création de nouvelles recettes
- **Liste** : Affichage de toutes les recettes
- **Détails** : Consultation d'une recette spécifique
- **Édition** : Modification des recettes existantes

## ✨ Fonctionnalités

- ✅ **Ajouter** une recette avec nom, ingrédients et étapes
- ✅ **Lister** toutes les recettes dans un RecyclerView
- ✅ **Consulter** les détails d'une recette
- ✅ **Modifier** une recette existante
- ✅ **Supprimer** une recette
- ✅ **Persistance locale** via SharedPreferences
- ✅ **Interface intuitive** avec navigation fluide

## 📱 Captures d'écran

| Accueil | Ajout | Liste | Détails |
|---------|-------|-------|---------|
| Navigation principale | Formulaire de création | RecyclerView des recettes | Fiche détaillée |

> **Note**: Ajoutez vos captures d'écran dans le dossier `/docs/screens/`

## 🏗️ Architecture

### Structure du projet
```
app/
├── src/main/java/
│   ├── MainActivity1.java    # Écran d'accueil
│   ├── MainActivity2.java    # Ajout de recette
│   ├── MainActivity3.java    # Liste des recettes
│   ├── MainActivity4.java    # Détails de recette
│   ├── MainActivity5.java    # Édition de recette
│   └── RecetteAdapter.java   # Adapter pour RecyclerView
├── res/layout/
│   ├── activity_main1.xml    # Layout accueil
│   ├── activity_main2.xml    # Layout ajout
│   ├── activity_main3.xml    # Layout liste
│   ├── activity_main4.xml    # Layout détails
│   ├── activity_main5.xml    # Layout édition
│   └── recipe_item.xml       # Layout item de liste
```

### Composants principaux
- **Présentation** : Activities classiques avec navigation par Intent
- **Liste** : RecyclerView avec RecetteAdapter et ViewHolder pattern
- **Navigation** : Intents avec extra "recipeData"
- **Persistance** : SharedPreferences avec clé "recetteApp"

## 🚀 Installation

### Prérequis
- Android Studio Flamingo ou version ultérieure
- JDK 8+
- Android SDK (API 21+)

### Étapes d'installation
1. **Cloner le repository**
   ```bash
   git clone https://github.com/votre-username/projet-recettes-android.git
   cd projet-recettes-android
   ```

2. **Ouvrir dans Android Studio**
   - File → Open → Sélectionner le dossier du projet
   - Attendre la synchronisation Gradle

3. **Lancer l'application**
   - Connecter un appareil Android ou lancer un émulateur
   - Cliquer sur Run 'app' ou `Shift + F10`

## 📖 Utilisation

### Démarrage rapide
1. **Ajouter une recette**
   - Accueil → "Ajouter une recette"
   - Remplir le formulaire (nom, ingrédients, étapes)
   - Appuyer sur "Enregistrer"

2. **Consulter les recettes**
   - Accueil → "Consulter les recettes"
   - Appuyer sur "Détails" pour voir une recette

3. **Modifier une recette**
   - Depuis les détails → "Modifier"
   - Modifier les champs souhaités
   - Sauvegarder les changements

4. **Supprimer une recette**
   - Depuis les détails → "Supprimer"
   - Confirmer la suppression

## 💾 Données et persistance

### Modèle de données
```
Format de sérialisation : "nom|ingrédients|étapes"
```

### Stockage local
- **Méthode** : SharedPreferences
- **Nom des préférences** : "recetteApp"
- **Clé** : "recette"
- **Type** : `Set<String>`

### Opérations CRUD
- **Create** : Ajouter une nouvelle chaîne au Set
- **Read** : Récupérer et parser le Set
- **Update** : Supprimer l'ancienne, ajouter la nouvelle
- **Delete** : Retirer la chaîne du Set

## ⚠️ Limitations

- Pas d'ID unique par recette (risque de collisions)
- Ordre des recettes non déterministe (nature du Set)
- Validation des champs basique
- Sérialisation fragile avec le caractère '|'
- Pas de fonctionnalité de recherche ou tri

## 🗺️ Roadmap

### Version 2.0
- [ ] Migration vers Room Database
- [ ] Ajout d'IDs uniques pour les recettes
- [ ] Fonctionnalité de recherche
- [ ] Tri des recettes (nom, date)

### Version 3.0
- [ ] Interface Material Design 3
- [ ] Mode sombre
- [ ] Sauvegarde cloud
- [ ] Partage de recettes

### Améliorations techniques
- [ ] Tests unitaires et d'intégration
- [ ] Architecture MVVM
- [ ] Gestion d'erreurs améliorée
- [ ] Internationalisation (i18n)

## 🤝 Contribuer

Les contributions sont les bienvenues ! Voici comment procéder :

1. **Fork** le projet
2. **Créer** une branche feature (`git checkout -b feature/AmazingFeature`)
3. **Commit** vos changements (`git commit -m 'Add: Amazing Feature'`)
4. **Push** sur la branche (`git push origin feature/AmazingFeature`)
5. **Ouvrir** une Pull Request

### Guidelines
- Respecter le style de code Android
- Ajouter des tests si nécessaire
- Documenter les nouvelles fonctionnalités
- Utiliser des commits clairs et descriptifs

## 👥 Auteurs

- **Achraf Menach** - *Développement initial* - [VotreGitHub](https://github.com/AchrafMenach)

## 📄 Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

## 🙏 Remerciements

- Communauté Android pour la documentation
- Stack Overflow pour les solutions techniques
- Contributeurs du projet

---

⭐ **N'hésitez pas à mettre une étoile si ce projet vous a aidé !**
