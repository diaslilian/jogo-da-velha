# 🎮 Jogo da Velha em Java

## 📖 Sumário
- [Sobre o Projeto](#sobre-o-projeto)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Como Executar](#como-executar)
- [Interface do Usuário](#interface-do-usuário)
- [Tratamento de Erros](#tratamento-de-erros)
- [Manutenção](#manutenção)
- [Informações Adicionais](#informações-adicionais)

## Sobre o Projeto

O Jogo da Velha é uma implementação em Java, desenvolvido para ser executado via console. O projeto foi criado com foco na organização do código e na experiência do usuário.

### ⚡ Características Principais
- Interface via console
- Dois jogadores
- Sistema de turnos
- Validação de jogadas
- Verificação automática de vitória/empate

## Estrutura do Projeto

### 📁 Organização dos Arquivos
```
src/
├── Main.java        # Ponto de entrada da aplicação
├── Jogo.java        # Controle do fluxo do jogo
├── Tabuleiro.java   # Lógica do tabuleiro
└── Jogador.java     # Dados dos jogadores
```

### 🔍 Descrição das Classes

#### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciar();
    }
}
```

#### `Jogador.java`
- **Atributos**
  - `nome`: Nome do jogador
  - `simbolo`: Símbolo do jogador (X ou O)
- **Métodos**
  - `getNome()`: Retorna o nome do jogador
  - `getSimbolo()`: Retorna o símbolo do jogador

#### `Tabuleiro.java`
- **Funcionalidades**
  - Inicialização do tabuleiro
  - Validação de jogadas
  - Verificação de vitória/empate
  - Exibição do estado atual

#### `Jogo.java`
- **Funcionalidades**
  - Registro de jogadores
  - Processamento de jogadas
  - Alternância entre jogadores
  - Interface com usuário

## Funcionalidades

### 🎯 Principais Recursos
1. **Registro de Jogadores**
   - Coleta nomes dos jogadores
   - Valida nomes únicos e não vazios

2. **Sistema de Jogo**
   - Alternância automática de turnos
   - Validação de jogadas
   - Verificação de vitória/empate

3. **Interface de Usuário**
   - Tabuleiro visual no console
   - Mensagens informativas
   - Feedback de jogadas

### 📋 Regras do Jogo
- Tabuleiro 3x3
- Jogadores alternam turnos (X e O)
- Vitória: 3 símbolos iguais em linha/coluna/diagonal
- Empate: Tabuleiro preenchido sem vencedor

## Como Executar

### 💻 Requisitos
- Java Development Kit (JDK) 8+
- Terminal/Console

### ⚙️ Instalação e Execução
```bash
# Clonar o repositório
git clone https://github.com/diaslilian/jogo-da-velha

# Navegar até a pasta do projeto
cd jogo-da-velha

# Compilar
javac *.java

# Executar
java Main
```

### 🎮 Como Jogar
1. Execute o jogo
2. Digite os nomes dos jogadores
3. Em cada turno:
   - Escolha a linha (0-2)
   - Escolha a coluna (0-2)
4. Para nova partida, digite 'S'

## Interface do Usuário

### 🎨 Visualização do Tabuleiro
```
  0 1 2
0 - - -
1 - - -
2 - - -
```

### 💬 Mensagens do Sistema
- **Início**
  - Boas-vindas
  - Solicitação de nomes
- **Durante o Jogo**
  - Indicação de turno
  - Feedback de jogadas
- **Fim de Jogo**
  - Anúncio de vencedor/empate
  - Opção de nova partida

## Tratamento de Erros

### ⚠️ Validações
- Nomes de jogadores
  - Não podem ser vazios
  - Não podem ser iguais
- Jogadas
  - Coordenadas válidas (0-2)
  - Posição disponível
  - Entrada numérica

### 🚫 Mensagens de Erro
```
"O nome não pode estar vazio"
"Os jogadores não podem ter o mesmo nome"
"Jogada inválida!"
"Entrada inválida! Use números de 0 a 2"
```

## Manutenção

### 🚀 Melhorias Futuras
- [ ] Sistema de placar
- [ ] Modos de jogo diferentes
- [ ] Interface gráfica
- [ ] IA para jogo single-player
- [ ] Sistema de ranking
- [ ] Histórico de partidas

### ⚠️ Limitações Conhecidas
- Apenas modo console
- Sem persistência de dados
- Interface textual básica
- Limitado a dois jogadores

## Informações Adicionais

### 📌 Versão
- **Versão:** 1.0
- **Data:** Novembro 2024

### 📞 Contato
- **Email:** [lilian.dias25@gmail.com]
- **GitHub:** [[diaslilian](https://github.com/diaslilian/)]

---

Desenvolvido com ❤️ por Lilian
