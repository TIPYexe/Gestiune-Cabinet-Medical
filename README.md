# Gestiune-Cabinet-Medical

Structura proiectului:
```
├───administrator
│       Cabinet.java
│       Client.java
│       Cos.java
│       Main.java
│       Medici.java
│       Oferte.java
│       Om.java
│       Produse.java
│       Programare.java
│       Service.java
│       Servicii.java
│       Stoc.java
│
├───database (tot ce trebuie pentru baza de date)
│       GenerateDB.java
│       INSERTURI.sql
│       Script.sql
│
└───repositories
        ClientRepository.java
        MediciRepository.java
        ProgramareRepository.java
        ServiciiRepository.java
```

# Mostenire
  Clasa Om sta la baza claselor [Client](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Client.java#L10-L11) si [Medici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Medici.java#L7-L8), pentru a nu duplica codul legat de nume, prenume, numar de telefon si mail.

# Sortare
  La afisarea tuturor programarilor, acestea sunt sortate dupa data la care trebuie efectuate. Vedeti [aici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Programare.java#L55-L61) si [aici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Main.java#L47).
  
# Functionalitati (noi fata de Tema1)
1. [Incarcarea din BD](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/administrator/Main.java#L58-L61) pentru [Programari](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ProgramareRepository.java#L11-L32), [Medici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/MediciRepository.java#L10-L26), [Clienti](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ClientRepository.java#L10-L29) si [Servicii](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ServiciiRepository.java#L10-L24) (Fac citirea din BB dupa fiecare functie rulata, pentru ca am delete on cascade-uri in BD, si cand stergem un lucru s-ar putea sa se stearga mai multe, dar din listele declarate in cod nu s-ar sterge);
2. INSERT in tabelele pentru [Programari](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ProgramareRepository.java#L34-L49), [Medici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/MediciRepository.java#L28-L39), [Clienti](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ClientRepository.java#L31-L45) si [Servicii](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ServiciiRepository.java#L26-L35);
3. DELETE pentru [Programari](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ProgramareRepository.java#L52-L63), [Medici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/MediciRepository.java#L41-L50), [Clienti](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ClientRepository.java#L47-L56) si [Servicii](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ServiciiRepository.java#L37-L46);
4. UPDATE pentru [Programari](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ProgramareRepository.java#L65-L130), [Medici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/MediciRepository.java#L52-L119), [Clienti](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ClientRepository.java#L58-L136) si [Servicii](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/0a9b2a2016cee9c6ac0c0225a07f18e4ad0aef25/src/repositories/ServiciiRepository.java#L48-L93);
