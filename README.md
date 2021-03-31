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
