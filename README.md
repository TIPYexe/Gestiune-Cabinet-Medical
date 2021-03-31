# Gestiune-Cabinet-Medical

Am implementat clasele:
  - Cabinet (pot fi mai multe cabinete detinute de aceeasi firma)
  - Medici
  - Programare
  - Client
  - Servicii
  - Stoc (la receptie se pot vinde diverse produse)
  - Produse
  - Oferte (ex: al doilea control gratuit, pachet de familie 2+1 analize)
  - Cos
  - Main
  - Service (la cerea dumneavoastra)
  - Om

# Mostenire
  Clasa Om sta la baza claselor [Client](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Client.java#L10-L11) si [Medici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Medici.java#L7-L8), pentru a nu duplica codul legat de nume, prenume, numar de telefon si mail.

# Sortare
  La afisarea tuturor programarilor, acestea sunt sortate dupa data la care trebuie efectuate. Vedeti [aici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Programare.java#L55-L61) si [aici](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Main.java#L47).
  
# Functionalitati
1. [Afiseaza programarile](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L41-L57).
2. [Adauga programare](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L59-L89).
3. [Actualizeaza data programare](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L90-L107).
4. [Asigneaza programarea altui medic](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L110-L120).
5. [Afiseaza stocul de produse](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L121-L132).
6. [Cauta produs dupa nume](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L134-L141).
7. [Actualizare produse stoc](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L143-L151).
8. [Adauga produs nou](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L153-L172).
9. [Schimba pretul de vanzare](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L174-L185).
10. [Schimba pretul de la retailer](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L187-L198).
