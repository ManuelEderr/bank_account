#Singleton

##Anwendungsbeispiel: 
eine Datenbankverbindung während der gesamten Anwendungslaufzeit herstellen. Wenn noch keine Verbindung hergestellt: verbinde, ansonsten bestehende Verbindung wiederherstellen.
##Funktionweise: 
Durch den "private" Konstruktor kann kein neues Objekt außerhalb der Klasse erzeugt werden. Es wird eine "public static getInstance()" Methode zum Erzeugen eines neues Objektes bereitsgestellt. Da sie mit "static" deklariert ist, muss für den Funktionsaufruf keine neue Instanz erzeugt werden. Eine "private static Singleton instance" Variable speichert die einmal erzeugte Instanz. Mittels einer "if - Condition" in dieser statischen Methode wird überprüft, ob bereits ein Objekt(einmalig!) erzeugt wurde.
```java
if (instance = null){instance = new Singleton}
```

#Factory

##Anwendungsbeistpiel: 
Wird oftmals bei Java Bibliotheken zum Erzeugen von Klassen genutzt.

##Funktionsweise: 
Es wird in einer 'Factory' Klasse eine Methode zum holen von Objekten bereitgestellt. Diese Methode nimmt eine Texteingabe (String) entgegen, interpretiert deren Inhalt und gibt aufgrunddessen ein entsprechendes Objekt zurück.
Ein allgemeines Interface ('ShapeInterface') wird von allen Klassen die als Rückgabewert in Betracht kommen, implementiert:
```java
public interface ShapeInterface{
    
}

public class Rectangle implements ShapeInterface{
    
}

public class Square implements ShapeInterface{
    
}

public class Circle implements ShapeInterface{
    
}
```

Das heißt also, die 'Facory' Klasse gibt ein allgemeines Objekt vom Type 'ShapeInterface' zurück. Welche Klasse tatsächlich zurückgegeben wird, wird erst zur
Laufzeit bestimmt. Man spricht auch von einem statischen Datentyp und einem dynamischen Datentyp.

```java
ShapeInterface obj = new Rectangle();

StatischerDatentyp obj = new DynamischerDatentyp();

```

Dieser Sachverhalt ist als Polymorphie bekannt.

#Observable Pattern (Publisher/Subscriber Pattern)

##Anwendungsbeispiel:
Automatische Benachrichtigung von Abonnenten (YouTube, Twitch) von Streamer.


##Funktionsweise:
In diesem Pattern gibt es Zuhörer/Abonnenten (Subscriber) die auf Benachrichtigungen vom Herausgeber (Publisher)
hören/warten. Derjenige, der Nachrichten veröffentlichen möchte, erbt von der abstrakten Klasse 
```java
public abstract class Publisher
```
In dieser abstrakten Klasse sind alle Methoden für das Hinzufügen und Entfernen von Abonnenten (Subscriber) definiert.
Außerdem ist eine Methode für die Benachrichtigungen aller Abonnenten enthalten. Alle Abonnenten implementieren
das 'Subscriber' - Interface und können sich in die Liste der Zuhörer beim Herausgeber ('Publisher') eintragen. 
In diesem `Subscriber` Interface sind die Methoden definiert, die bei einer Benachrichtigung durch den Herausgeber
aufgerufen werden. 
Der Herausgeber (`Publisher`) regiert nun auf bestimmte Events und benachrichtigt alle seine Abonnenten (`Subscriber`).
Da jeder Abonnent das `Subscriber` Interface implementiert, ist eine individuelle Reaktion auf die Benachrichtigung möglich.

#Decorator Pattern

##Anwendungsmöglichkeiten:
Ein großes, gut getestetes Programm soll um zusätzliche Funktionalitäten erweitert werden. Wichtig dabei ist, dass die 
bestehende Funktionalität weiterhin bestehen bleibt. 

##Funktionsweise:
Die bestehenden Klassen implementiern ein gemeinsames ShapeInterface. (z.B. Rectangle, Circle, Square). Der
Decorator implementiert ebenfalls dieses ShapeInterface und nimmt im Konstruktor ein Objekt vom Typ `ShapeInterface`
entgegen (z.B. Rectangle, Circle, Square). Dadurch wird sichergestellt, dass der Decorator die selben Methoden 
wie die bereits bestehendes Klassen hat. Es wird also den bestehenden Klassen ein Decorator "übergestülpt".
Somit wird ermöglicht, dass der Dekorator die bestehende Funktionalität erweitern kann.
```java
public class RedShapeDecorator implements ShapeInterface{
    private ShapeInterface objectToDecorate = null;
    public RedShapeDecorator(ShapeInterface obj){
        this.objectToDecorate = obj;
    }
    @Override
    public void draw(){
        //  eigene Logik (male Objekt rot aus)
        this.objectToDecorate.draw(){
            // eigene Logik (male den Rahmen des Objekts rot aus)
        }
    }
}
```
