# 🏠 Simulador de Financiamento Imobiliário em Java

Projeto acadêmico desenvolvido em Java para a disciplina de **Programação Orientada a Objetos (POO)**, aplicando os principais pilares da orientação a objetos em um sistema de simulação de financiamentos imobiliários.

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![POO](https://img.shields.io/badge/POO-Herança%20%7C%20Polimorfismo-blue?style=flat)
![Status](https://img.shields.io/badge/Status-Concluído-green?style=flat)

---

## 📋 Sobre o projeto

Sistema que permite simular financiamentos de 3 tipos de imóveis — **Casa**, **Apartamento** e **Terreno** — com cálculo automático de parcelas mensais, total do financiamento e persistência dos dados em arquivos.

---

## 🏗️ Arquitetura — Hierarquia de classes

```
Financiamento (abstract)
├── Casa
│   └── acréscimo fixo de R$80/mês + validação por exceção
├── Apartamento
│   └── vagas de garagem + número do andar
└── Terreno
    └── acréscimo de 2% por mês + tipo de zona
```

A classe `Financiamento` é **abstrata** — define o contrato comum, mas cada subclasse implementa seu próprio cálculo de parcela.

---

## ⚙️ Funcionalidades

- **Cadastro interativo** — usuário escolhe o tipo de imóvel e informa os dados
- **Financiamentos de exemplo** — opção de adicionar dados pré-definidos para teste
- **Cálculo de parcela mensal** — fórmula de juros compostos com regra específica por tipo
- **Resumo completo** — exibe valor do imóvel, taxa, prazo, parcela e total pago
- **Totalizador** — soma o valor de todos os imóveis e o total de todos os financiamentos
- **Persistência em arquivo de texto** — salva e lê os dados em formato CSV (`.txt`)
- **Serialização** — salva e lê o `ArrayList` inteiro em arquivo binário (`.dat`)

---

## 🧱 Conceitos de POO aplicados

| Conceito | Como foi aplicado |
|----------|------------------|
| **Herança** | `Casa`, `Apartamento` e `Terreno` herdam de `Financiamento` |
| **Polimorfismo** | Cada subclasse sobrescreve `calcularPagamentoMensal()` e `calcularTotalPagamento()` |
| **Abstração** | `Financiamento` é abstrata — não pode ser instanciada diretamente |
| **Interface** | `Salvavel` define o contrato `toCSV()` para serialização em texto |
| **Encapsulamento** | Atributos protegidos, acesso via métodos |
| **Exceção customizada** | `AumentoMaiorDoQueJurosException` lançada quando o acréscimo da Casa ultrapassa metade dos juros |

---

## 📁 Estrutura do projeto

```
src/
├── main/
│   └── Main.java              # Ponto de entrada e fluxo principal
├── modelo/
│   ├── Financiamento.java     # Classe abstrata base
│   ├── Casa.java              # Subclasse com acréscimo fixo
│   ├── Apartamento.java       # Subclasse com dados do apartamento
│   ├── Terreno.java           # Subclasse com acréscimo percentual
│   ├── Salvavel.java          # Interface para exportação CSV
│   └── AumentoMaiorDoQueJurosException.java  # Exceção customizada
└── util/
    ├── ArquivoUtil.java       # Leitura e escrita de arquivos
    └── InterfaceUsuario.java  # Validação de entradas do usuário
```

---

## 🛠️ Tecnologias

- **Java** — linguagem principal
- **POO** — herança, polimorfismo, abstração, encapsulamento
- **ArrayList** — gerenciamento da coleção de financiamentos
- **Java I/O** — `BufferedWriter`, `BufferedReader`, `FileWriter`
- **Serialização** — `ObjectOutputStream`, `ObjectInputStream`, `Serializable`
- **Exceções customizadas** — `extends Exception`

---

## 👨‍💻 Autor

**Tiago Banzato** — Estudante de ADS

[![LinkedIn](https://img.shields.io/badge/LinkedIn-tiagobanzato-0077B5?style=flat&logo=linkedin)](https://www.linkedin.com/in/tiagobanzato)
