# Real Estate Financing Simulator in Java

Academic project built in Java for an **Object-Oriented Programming (OOP)** course, applying the core OOP principles in a real estate financing simulation system.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Inheritance%20%7C%20Polymorphism-555555?style=flat)
![Status](https://img.shields.io/badge/Status-Completed-green?style=flat)

---

## About the project

The system simulates financing for 3 property types (**Casa** / house, **Apartamento** / apartment and **Terreno** / land), automatically calculating monthly instalments and the total amount financed, and persisting the data to files.

---

## Architecture: class hierarchy

```
Financiamento (abstract)
├── Casa (house)
│   └── fixed surcharge of R$80/month + exception-based validation
├── Apartamento (apartment)
│   └── parking spaces + floor number
└── Terreno (land)
    └── 2% monthly surcharge + zoning type
```

The `Financiamento` class is **abstract**: it defines the common contract, while each subclass implements its own instalment calculation.

---

## Features

- **Interactive input**: the user picks a property type and enters its details
- **Sample data**: option to load predefined financing records for testing
- **Monthly instalment calculation**: compound interest formula with type-specific rules
- **Full summary**: shows property value, interest rate, term, instalment and total paid
- **Totals**: sums the value of all properties and the total of all financing plans
- **Text file persistence**: saves and reads data in CSV format (`.txt`)
- **Serialization**: saves and reads the whole `ArrayList` to/from a binary file (`.dat`)

---

## OOP concepts applied

| Concept | How it was applied |
|---------|--------------------|
| **Inheritance** | `Casa`, `Apartamento` and `Terreno` extend `Financiamento` |
| **Polymorphism** | Each subclass overrides `calcularPagamentoMensal()` and `calcularTotalPagamento()` |
| **Abstraction** | `Financiamento` is abstract and cannot be instantiated directly |
| **Interface** | `Salvavel` defines the `toCSV()` contract for text export |
| **Encapsulation** | Protected attributes, accessed through methods |
| **Custom exception** | `AumentoMaiorDoQueJurosException` is thrown when the house surcharge exceeds half of the interest |

---

## Project structure

```
src/
├── main/
│   └── Main.java                          # Entry point and main flow
├── modelo/
│   ├── Financiamento.java                 # Abstract base class
│   ├── Casa.java                          # Subclass with fixed surcharge
│   ├── Apartamento.java                   # Subclass with apartment details
│   ├── Terreno.java                       # Subclass with percentage surcharge
│   ├── Salvavel.java                      # Interface for CSV export
│   └── AumentoMaiorDoQueJurosException.java  # Custom exception
└── util/
    ├── ArquivoUtil.java                   # File read/write
    └── InterfaceUsuario.java              # User input validation
```

---

## Tech stack

- **Java**: main language
- **OOP**: inheritance, polymorphism, abstraction, encapsulation
- **ArrayList**: managing the collection of financing plans
- **Java I/O**: `BufferedWriter`, `BufferedReader`, `FileWriter`
- **Serialization**: `ObjectOutputStream`, `ObjectInputStream`, `Serializable`
- **Custom exceptions**: `extends Exception`

---

## Author

**Tiago Banzato**  
Software developer · Dublin, Ireland

[![GitHub](https://img.shields.io/badge/GitHub-tiagobanzato-black?logo=github)](https://github.com/tiagobanzato)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-banzato-0A66C2?style=flat&logo=linkedin)](https://www.linkedin.com/in/banzato)
