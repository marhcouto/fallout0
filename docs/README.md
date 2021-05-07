# **LPOO - Fallout: A post pandemic RPG**

# Tabela de Conteúdos
(Vai ser o índice)

# Funcionalidades

## Implementadas

### Estado *Wandering*
- Movimento do herói
- Desenho do herói e da arena


## Por implementar
-


# Design

## Atributos
### Contexto do Problema
Tanto o nosso personagem quanto os monstros que enfrentará terão atributos que governarão a aptidão para o combate, a capacide de auto-cura, etc.
Estes atributos também serão partilhados com as armas, que poderão exigir um valor mínimo para serem manuseadas, e com os equipamentos, que terão os seus próprios atributos e funcionarão como boost aos atributos base das personagens.

### _Design Pattern_
A solução de este problema passou pela criação de uma classe ***Attributes*** que irá ter todos os atributos que os personagens podem possuir e que as armas podem exigir. Se uma arma não exigir um determinado atributo ou o personagem/equipamento não tiver um atributo, o seu valor é simplesmente zero. 

### Implementação
<p align="center">
  <img width=650 src="images/attributes.svg">
</p>

### Consequências
 - Respeito dos principios SOLID
 - Algumas armas e personagens (maioritariamente monstros) podem estar cientes de atributos que não possuem. Por exemplo, um monstro pode não ter inteligência e nesse caso o atributo está a zero quando podia não existir.

## Movimentação dos Personagens
### Contexto do problema
O nosso personagem e os monstros vão ter estratégias de movimentação diferentes consoante o seu tipo. Como a movimentação dos monstros é maioritáriamente autonoma e diferente para as várias situações, produzir bons testes para as funções que lidam com movimentação poderia ser difícil. Queremos portanto uma classe que trate da movimentação do monstro, mas queremos que cada monstro se comporte de maneira diferente.

### Design Pattern
Para resolver este problema decidimos utilizar o *Factpry Pattern*, para que a estratégia de movimentação possa ser definida nas classes filhas, sem necessidade da classe mãe (Monstro ou Enemy) anticipe o comportamento dos monstros. Além disto, ao ter classes separadas para o movimento (MovementEngines), o teste da movimentação dos monstros é facilitada.

### Implementação
<p align="center">
  <img width=650 src="images/movement.svg">
</p>

### Consequências
 - Respeito do Open closed principle. Para adicionar uma estratégia de movimento basta criar uma nova subclasse. 
 - Código mais fácil de testar

## Diferentes Estados de Jogo
### Contexto do problema
O nosso jogo estará dividido em vários estados, cujo comportamento e aspeto deverá ser diferente. Há, portanto, necessidade do jogo se comportar manifestamente diferente consoante o estado, sendo que este se altera durante o funcionamento do jogo.

### Design Pattern
Para este efeito, decidimos implementar o *State Pattern*, com umas pequenas alterações: dada a necessidade de voltar a estados com praticamente a mesma informação que os anteriores, implementámos uma *stack* no Game com os diferentes estados, sendo assim o state ativo aquele que se encontra no topo da mesma. 

### Implementação


### Consequências
