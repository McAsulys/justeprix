# Le Juste Prix
Application Compose Desktop pour jouer au jeu du juste prix.

## Build & run
```bash
gradle run
```

## Package pour Windows 64-bit
```bash
gradle packageDistributionForCurrentOS
```
→ Le fichier `.msi` est généré dans `build/compose/binaries/main/`.

## Dépendances
- Kotlin/JVM 2.2.0
- Compose Multiplatform Desktop 1.8.0
- JDK 21 (Temurin)
