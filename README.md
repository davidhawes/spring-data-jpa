# Spring Data JPA

### Entity Student
1. Mit @Table wird der name des Tables definiert
2. Mit @Column wird der name des Columns definiert
3. Mit @SequenceGenerator + @GeneratorValue wird die ID generiert.

![image](https://user-images.githubusercontent.com/83290245/142036712-46748ab8-496a-4a8b-a978-35ac3c793e5a.png)

4. in @Table wird der Constraint auch noch angegeben

![image](https://user-images.githubusercontent.com/83290245/142037793-bdefef44-0434-47e1-b44e-d37efd9f650f.png)


#### StudentRepository

![image](https://user-images.githubusercontent.com/83290245/142042749-be2206c1-1cc3-4ba9-bf15-9bd87767f233.png)


#### Testklasse von StudentRepository

1. @Springboottest gibt an, dass diese Klasse eine Testklasse ist (altv. sollte man DataJPA verwenden)
2. Die Methode saveStudent() speichert Daten und mit der Methode printAllStudent() kann man diese Daten ausgeben lassen

![image](https://user-images.githubusercontent.com/83290245/142042877-eda75a2f-cebf-496a-b2d7-faaa99b2cc05.png)

Student alleine oder Student+Guardian

![image](https://user-images.githubusercontent.com/83290245/142046262-005420ac-6bd9-4e19-9c00-e62b20d61684.png)

Find-Methoden (später hinzugefügt)

![image](https://user-images.githubusercontent.com/83290245/142049920-eaaca123-40a9-428c-897c-4df27914ffb3.png)


#### Embeddable Guardian Klasse
@Embeddable macht diese Klasse Embeddable

![image](https://user-images.githubusercontent.com/83290245/142046470-f984db2c-050d-44f6-aa98-e4c3e7994cd3.png)

Dies wird dann statt den Datenfeldern in der Student Klasse eingefügt

![image](https://user-images.githubusercontent.com/83290245/142046584-3c1aad42-375d-43b6-8aef-617da8433306.png)



### Queries

1. Eine Query um einen Student mit seiner Email zu finden.
2. @Query gibt eine JPQL Query an, womit die Funktion den Student finden sollte

![image](https://user-images.githubusercontent.com/83290245/142052195-60552523-3794-4ba9-a015-b2793b4a0313.png)

3. Diese @Query gibt den Firstname des Gesuchten Student als String aus

![image](https://user-images.githubusercontent.com/83290245/142053187-21b000c3-47e5-476b-82ec-42a0e9beece5.png)

4. Native Query

![image](https://user-images.githubusercontent.com/83290245/142056298-ec93b2ea-d5b7-4777-b953-20bb3d01fcfe.png)

5. Native Query mit einem Named Parameter

![image](https://user-images.githubusercontent.com/83290245/142056829-725013c7-d008-479c-b2d6-0e6b31a14b96.png)

6. Update Query, welche mit @Modifying den Namen modifiziert/ändert und mit @Transactional die Transaktionsinformation in der Datenbank speichert

![image](https://user-images.githubusercontent.com/83290245/142057707-3fc02cb7-b360-40d8-a012-55a6168dcc82.png)



### Entity Course und CourseMaterial

![image](https://user-images.githubusercontent.com/83290245/142063078-9dc2d3f7-4d23-4c01-865a-5a5d12d802ce.png)

1. @OneToOne macht die Beziehung zwischen Course und CourseMaterial
2. @JoinColumn joint die Spalten

![image](https://user-images.githubusercontent.com/83290245/142063771-6dfad14a-a83c-456f-b34d-d945d315ef64.png)

3. Mit der Testmethode SaveCourseMaterial() wird überprüft, ob man Daten speichern kann

![image](https://user-images.githubusercontent.com/83290245/142064890-10f13af9-4704-4af5-aebd-30561b7c34fc.png)

4. Damit die Methode funktioniert, muss man eine Cascade-Type bei der @OneToOne Beziehung verwenden

![image](https://user-images.githubusercontent.com/83290245/142065123-0ffd0555-0936-4426-a3c4-26c53b5a16c4.png)


#### Fetchen von Daten

1. CourseMaterials
Als Fetchtype wird hier LAZY verwendet. Dies gibt nur die Daten vom jeweiligen CourseMaterial aus.

![image](https://user-images.githubusercontent.com/83290245/142066986-35f54a36-c38b-4b0a-9c3e-c0ee9a7f88fb.png)

Ausgabe

![image](https://user-images.githubusercontent.com/83290245/142066953-3ec8db01-35fa-40de-8cf3-e996144f7ec6.png)


2. Courses

![image](https://user-images.githubusercontent.com/83290245/142068817-86a0faa8-1593-4523-8763-d33aea4d3420.png)

Ausgabe 

![image](https://user-images.githubusercontent.com/83290245/142068887-903648ff-6e97-429e-8419-e471691bd878.png)


#### OneToOne Beziehung Bi directional machen

1. @OneToOne Annotation in Course Entity einfügen
2. Die zwei Entities sind schon in der CourseMaterial Entity gejoint und daher muss man das mappedBy angeben

![image](https://user-images.githubusercontent.com/83290245/142070458-5f58112f-2f29-4ceb-8b97-cfc3a65c595e.png)

3. Ausgabe nach dem Bi directional machen

![image](https://user-images.githubusercontent.com/83290245/142070356-f3635d5c-6917-4db8-8419-ba733e4f94d7.png)



