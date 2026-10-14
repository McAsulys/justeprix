# Le Juste Prix
Application Compose Desktop pour jouer au jeu du juste prix.

## Build & run
```bash
gradle run
```

## Package pour Windows 64-bit
**Option A : Sur Windows**
```powershell
gradlew.bat packageDistributionForCurrentOS
```
→ Le fichier `.msi` est généré dans `build/compose/binaries/main/`.

**Option B : Fichier pré-compilé**
Télécharge directement le `.msi` ici :  
🔗 [justeprix-1.0.0.msi](https://github.com/McAsulys/justeprix/releases/latest/download/justeprix-1.0.0.msi) *(bientôt disponible)*

## Dépendances
- Kotlin/JVM 2.2.0
- Compose Multiplatform Desktop 1.8.0
- JDK 21 (Temurin)

## Fonctionnalités
- Nombre aléatoire entre 1 et 100
- Feedback visuel (Plus haut / Plus bas / Bravo !)
- Compteur de tentatives
- Bouton "Recommencer" pour un nouveau jeu
