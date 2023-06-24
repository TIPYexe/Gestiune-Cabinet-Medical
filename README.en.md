[![en](https://img.shields.io/badge/lang-en-green.svg)](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/master/README.en.md)
[![ro](https://img.shields.io/badge/lang-ro-red.svg)](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/master/README.md)

# Medical Clinic Management

I have implemented the following classes:
  - Cabinet (there can be multiple cabinets owned by the same company)
  - Doctors
  - Appointments
  - Client
  - Services
  - Stock (various products can be sold at the reception)
  - Products
  - Offers (e.g., second free check-up, family package 2+1 analysis)
  - Cart
  - Main
  - Service (upon your request)
  - Person

# Inheritance
The Person class serves as the base for the classes [Client](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Client.java#L10-L11) and [Doctors](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Medici.java#L7-L8), in order to avoid duplicating code related to name, surname, phone number, and email.

# Sorting
When displaying all appointments, they are sorted by the date they need to be performed. See [here](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Programare.java#L55-L61) and [here](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/1b3624ddb6bdd677b3e6ed9721000ee8e772aa1e/src/administrator/Main.java#L47).

# Functionalities
1. [Display appointments](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L41-L57).
2. [Add appointment](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L59-L89).
3. [Update appointment date](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L90-L107).
4. [Assign appointment to another doctor](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L110-L120).
5. [Display product stock](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L121-L132).
6. [Search product by name](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L134-L141).
7. [Update product stock](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L143-L151).
8. [Add new product](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L153-L172).
9. [Change selling price](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L174-L185).
10. [Change retailer price](https://github.com/TIPYexe/Gestiune-Cabinet-Medical/blob/44d901ee3e0cd56cb88286633d5d91697095e845/src/administrator/Main.java#L187-L198).
