
## 0.1 - Mise en place du prototype de viewer

- [x] Affichage d'un SVG contenant des cercles et des rectangles

---

## 0.2 - Rendre le code plus robuste en cas de type inconnu dans le fichier SVG

Bug : Le programme plante lamentablement quand il rencontre une balise inconnue.

- [x] Ajouter un test fonctionnel sur [src/test/resources/svg/shapes.svg](src/test/resources/svg/shapes.svg)

- [x] Dans la classe SVGReader, Logger et ignorer les éléments innutiles ou inconnu, respectivement (title, desc) et (line, text, etc.)

---

## 0.3 - Ajout d'une Shape "Line"

- [x] Créer la classe Line en vous inspirant de la modélisation SVG

- [x] Remplacer le switch dans SVGReader.parseShapeElement par l'appel à une stratégie de lecture

```
interface SVGElementReader {
    public Shape read(Element shapeElement) ;
}
```

Remarque : Faire appel à une SVGElementReaderRegistry pour récupérer
le SVGElementReader correspondant au type adéquat.

```
class SVGElementReaderRegistry {
    private Map<String, SVGElementReader> readers = new HashMap<String,SVGElementReader>();

    public SVGElementReader getReader(String type){
        //...
    }
}
```

---

## 0.4 - Gestion des styles

- [x] Mettre en place une classe "Style"

Pour simplifier, on s'inspirera de [OpenLayers 2](http://docs.openlayers.org/library/feature_styling.html#style-properties)
avec deux attributs fillColor et strokeColor (java.awt.Color).

- [x] Ajouter un attribut style de type Style aux Shape

On ajoutera une classe AbstractShape pour éviter de répéter les codes
sur les différentes classes concrètes.

- [x] Mettre à jour SVGReader pour parser les styles

- [x] Mettre à jour les méthodes de rendu des Shape


---

## 0.5 - Ajout du concept de Scene et de View

On travaille actuellement avec des "Graphics" en faisant des rendus en
mode plein écran. On va préparer le terrain pour être à même de gérer
facilement :

* Le redimensionnement de la fenêtre
* Un facteur d'échelle (zoom +, zoom -)
* L'ajout d'un menu dans la fenêtre
* ...

On va ajouter deux concepts :

* La Scene : La liste des formes à afficher
* La View : Cadre d'affichage des affichages des objets

- [ ] Créer la classe Scene
- [ ] Créer la classe View qui héritera de JPanel et sera porteuse de la scene
- [ ] Mettre à jour le viewer pour qu'il s'appuie sur la View

Le rendu d'un JPanel est effectué à l'aide de paintComponent :

```
    @Override
	public void paintComponent(Graphics g) {
	    // rendu de la scene
    }
```

---

## 0.6 - Prise en compte de la dimension de l'image SVG

On va exploiter la taille de l'image SVG pour créer une View de dimension
équivalente.

- [ ] Mettre à jour SVGReader pour renvoyer une View
- [ ] Mettre à jour les codes impactés

Remarque : La taille de l'image SVG est portée par la racine du document XML

```(svg)
<svg width="400" height="180">
```


---

## 0.7 - Externalisation du code lié au rendu

Le rendu ne devrait pas être effectué par les shapes.

- [ ] Créer une interface ShapeVisitor
- [ ] Implémenter un RenderShapeVisitor
- [ ] Mettre à jour la View pour s'appuyer sur RenderShapeVisitor

---

## 0.8 - Ajout de zoom + et zoom -

On va ajouter la notion de facteur d'échelle sur la vue et implémenter
un zoom + et un zoom -.

- [ ] Ajouter un attribut "scale" (double) sur la vue
- [ ] Appliquer le facteur d'échelle dans le rendu
- [ ] Ecouter les événements claviers pour multiplier ou diviser le facteur d'échelle par 1.2

On s'appuyera sur [java.awt.geom.AffineTransform](https://docs.oracle.com/javase/7/docs/api/java/awt/geom/AffineTransform.html)
pour appliquer le facteur d'échelle.

```
AffineTransform transform = new AffineTransform();
g2d.scale(2.0,2.0);

Graphics2D g2d = (Graphics2D)graphics;
g2d.setTransform(transform);

// draw shapes
```

---

Si on vient à s'ennuyer, on pourra :

* Permettre la translation à l'aide de la souris
* Uniformiser les contrôles
* Ajouter des contrôles de dessin (création d'une Line, d'un Circle, d'un Rectangle)
* Ajouter un mécanisme d'annulation sur les contrôles de dessin
...
