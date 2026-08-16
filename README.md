# 🎵 AudioPlayer — Adapter Pattern

## Patrones Estructurales

**Autor:** Daniel Felipe Forero Sánchez

---

## 📌 Descripción

Este proyecto implementa el patrón estructural **Adapter** para permitir que diferentes reproductores de audio con interfaces incompatibles puedan utilizarse mediante una única interfaz:

```java
AudioPlayer
```

El objetivo es que `Client` pueda reproducir diferentes formatos sin conocer directamente los reproductores externos.

Los formatos principales soportados son:

- MP4
- VLC
- FLAC
- AAC

---

## 🔌 Patrón Adapter

Los proveedores externos utilizan métodos diferentes para reproducir audio.

Para solucionar esta incompatibilidad se crearon adaptadores que permiten utilizarlos mediante `AudioPlayer`.

```text
                Client
                  │
                  ▼
              AudioPlayer
                  │
                  ▼
          AudioPlayerAdapter
                  │
        ┌─────────┴─────────┐
        │                   │
        ▼                   ▼
AdvancedAudioPlayer   PremiumAudioPlayer
     Adapter               Adapter
        │                   │
        ▼                   ▼
AdvancedAudioPlayer   PremiumAudioPlayer
```

### AdvancedAudioPlayerAdapter

Se encarga de adaptar los formatos:

```text
MP4
VLC
```

hacia los métodos correspondientes de `AdvancedAudioPlayer`.

### PremiumAudioPlayerAdapter

Se encarga principalmente de:

```text
FLAC
AAC
```

utilizando `PremiumAudioPlayer`.

Como este proveedor requiere un volumen obligatorio y `AudioPlayer` no lo recibe, se utiliza un **volumen por defecto del 50 %**.

---

## 🔄 Funcionamiento

`Client` trabaja únicamente con:

```java
AudioPlayer audioPlayer = new AudioPlayerAdapter();
```

Luego puede reproducir diferentes formatos utilizando siempre:

```java
audioPlayer.play(audioType, fileName);
```

Los adaptadores se encargan de traducir la operación al proveedor correspondiente.

El método:

```java
audioPlayer.stop();
```

también es adaptado al método necesario para detener el reproductor que se encuentre activo.

---

## 🛠️ Compilación

Desde la carpeta raíz del proyecto:

```powershell
mvn compile
```

Una compilación correcta debe finalizar con:

```text
BUILD SUCCESS
```

---

## ▶️ Ejecución

Ejecutar:

```powershell
mvn exec:java "-Dexec.mainClass=edu.unisabana.dyas.patterns.Client"
```

---

## 📝 Conclusión

El patrón **Adapter** permite que `Client` utilice diferentes proveedores de audio mediante una misma interfaz, sin depender directamente de las APIs externas.

En resumen:

```text
Diferentes proveedores
        +
      Adapter
        =
Una interfaz común
```

---

## 👨‍💻 Autor

**Daniel Felipe Forero Sánchez**