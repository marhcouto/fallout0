# **LPOO - Fallout: A post pandemic RPG**

# Tabela de Conteúdos
- [**LPOO - Fallout: A post pandemic RPG**](#lpoo---fallout-a-post-pandemic-rpg)
- [Tabela de Conteúdos](#tabela-de-conteúdos)
- [Funcionalidades](#funcionalidades)
  - [Implementadas](#implementadas)
  - [Por implementar](#por-implementar)
- [Design](#design)
  - [Padrão Arquitetural](#padrão-arquitetural)
    - [Contexto do problema](#contexto-do-problema)
    - [Design Pattern](#design-pattern)
    - [Implementação](#implementação)
    - [Consequências](#consequências)
  - [Atributos](#atributos)
    - [Contexto do Problema](#contexto-do-problema-1)
    - [Design Pattern](#design-pattern-1)
    - [Implementação](#implementação-1)
    - [Consequências](#consequências-1)
  - [Movimentação dos Personagens](#movimentação-dos-personagens)
    - [Contexto do problema](#contexto-do-problema-2)
    - [Design Pattern](#design-pattern-2)
    - [Implementação](#implementação-2)
    - [Consequências](#consequências-2)
  - [Diferentes Estados de Jogo](#diferentes-estados-de-jogo)
    - [Contexto do problema](#contexto-do-problema-3)
    - [Design Pattern](#design-pattern-3)
    - [Implementação](#implementação-3)
    - [Consequências](#consequências-3)
  - [Escolha do desenho das personagens](#escolha-do-desenho-das-personagens)
    - [Contexto do problema](#contexto-do-problema-4)
    - [Design pattern](#design-pattern-4)
    - [Implementação](#implementação-4)
    - [Consequências](#consequências-4)
  - [Estados distintos - Gráficos diferentes](#estados-distintos---gráficos-diferentes)
    - [Contexto do problema](#contexto-do-problema-5)
    - [Solução](#solução)
  - [Group Renderers](#group-renderers)
    - [Contexto do problema](#contexto-do-problema-6)
    - [Design Pattern](#design-pattern-5)
    - [Implementação](#implementação-5)
    - [Consequeências](#consequeências)
  - [Menu - Opções disponíveis para o utilizador](#menu---opções-disponíveis-para-o-utilizador)
    - [Contexto do problema](#contexto-do-problema-7)
    - [Design Pattern](#design-pattern-6)
    - [Implementação](#implementação-6)
    - [Consequencias](#consequencias)

# Funcionalidades
  
## Implementadas
- Ecrã inicial: menu onde o jogador terá 5 pontos para distribuir pelos 4 atributos para poder criar o seu personagem
<p align = "center">
  <img width = 450 src = "images/features/characterCreation.gif">
</p>

- Modo de batalha: modo onde é efetuada uma batalha por turnos contra um inimigo.
<p align = "center">
  <img width = 450 src = "images/features/battle.gif">
</p>

- Movimento do herói: o herói move-se pela arena e o seu movimento é controlado através de teclas do teclado
- Desenho do herói e da arena: a arena e os seus componentes (monstros e paredes), bem como o herói (Vault Boy), são desenhados no terminal do Lanterna
- Movimento dos monstros: os monstros movem-se na arena
- Deteção do inicio de batalha: quando o range do Vault Boy colide com o range de um monstro que esteja no seu campo de visão (sem paredes entre estes), a batalha inicia
<p align = "center">
  <img width = 450 src = "images/features/battleStart.gif">
</p>

 - Ficheiros de jogo: carregamento da arena e outras informações através de ficheiros de jogo
 - Transição entre arenas: existem mais do que uma arena e o jogador viaja entre elas através das suas portas
<p align = "center">
  <img width = 450 src = "images/features/arenaTransition.gif">
</p>

- Gravação de dados: o jogador pode guardar os dados da partida (em ficheiros) para que o jogo guarde o progresso
- Progressão do personagem: à medida que os inimigos são derrotados o nosso personagem acumula experiência que pode ser usada para melhorar os seus atributos
<p align = "center">
  <img width = 450 src = "images/features/levelUP.gif">
</p>

## Por implementar
- Menu de Wander: menu onde o jogador poderá editar o seu equipamento e arma, percorrer o seu inventário e obter outro tipo de informações
- Loot: Sistema de *loot* para que o jogador possa apanhar diferentes armas (e possivelmente equipamento) para lutar com os inimigos que encontrará
- Equipamentos: sistema de armaduras e outros equipamente que darão atributos bónus ao personagem (e possivelmente aos monstros)
- NPCs: o jogador poderá interagir com um personagem não jogável para trocar o dinheiro ganho em batalha por novas armas e armaduras

# Design

## Padrão Arquitetural
### Contexto do problema
O padrão arquitetural foi a primeira escolha feita no desenvolvimento do programa. A escolha do padrão arquitetural é de extrema importância porque dita a estrutura básica do programa.
### Design Pattern
Como padrão arquitetural foi utilizado uma combinação de MVC com ***State Pattern***. Cada ***State Pattern*** contém um ***MVC***. A classe ***Game*** contém uma *stack* de estados e cada vez que queremos trocar de estado basta mudar o topo da *stack*. O controller é uma classe genérica que recebe um *model*. O *viewer* recebe um *model* e uma interface do tipo *GUI* e o state apenas necessita do *model* porque a partir deste tanto o *viewer* como o *controller* podem ser gerados. 
### Implementação
Apenas foi apresentado um estado do jogo para simplificar o diagrama de classes. 
<p align="center">
  <img width=650 src="images/uml/MVC.svg">
</p>

### Consequências
 - É mais fácil expandir o programa
 - Cada estado funciona isolado dos outros estados.
 - É mais fácil testar os componenetes individuais. Por exemplo textar o model de forma isolada do controller.
 - O mais simples menu necessita de pelo menos quatro classes para ser representado.

## Atributos
### Contexto do Problema
Tanto o nosso personagem quanto os monstros que enfrentará terão atributos que governarão a aptidão para o combate, a capacide de auto-cura, etc.
Estes atributos também serão partilhados com as armas, que poderão exigir um valor mínimo para serem manuseadas, e com os equipamentos, que terão os seus próprios atributos e funcionarão como boost aos atributos base das personagens.

### Design Pattern
A solução de este problema passou pela criação de uma classe ***Attributes*** que irá ter todos os atributos que os personagens podem possuir e que as armas podem exigir. Se uma arma não exigir um determinado atributo ou o personagem/equipamento não tiver um atributo, o seu valor é simplesmente zero. 

### Implementação
<p align="center">
  <img width=650 src="images/attributes.svg">
</p>

### Consequências
 - Respeito dos principios SOLID
 - Algumas armas e personagens (maioritariamente monstros) podem estar cientes de atributos que não possuem. Por exemplo, um monstro pode não ter inteligência e nesse caso o atributo está a zero quando podia não existir.

<br>

## Movimentação dos Personagens
### Contexto do problema
Queriamos dar suporte tanto a estratégias de movimentação alternativas para poder suportar movimentações que considerem, por exemplo, as posições relativas dos elementos na arena. Para além disso, queriamos tornar mais fácil a testagem da movimentação dos personagens.

### Design Pattern
Para resolver este problema decidimos utilizar o *Strategy Pattern*, para que o nosso EnemyController possa receber uma *engine* de movimentação arbitrária.

### Implementação
<p align="center">
  <img width=650 src="images/uml/movement.svg">
</p>

### Consequências
 - Respeito do Open closed principle. Para adicionar uma estratégia de movimento basta criar uma nova subclasse.
 - Respeito do Dependency inversion principle. O nosso EnemyController depende de uma interface que define MovingEngine.
 - Código mais fácil de testar. Podemos criar mocks deterministicos de MovingEngine para realizar testes.
 
<br>

## Diferentes Estados de Jogo
### Contexto do problema
O nosso jogo estará dividido em vários estados, cujo comportamento e aspeto deverá ser diferente. Há, portanto, necessidade do jogo se comportar manifestamente diferente consoante o estado, sendo que este se altera durante o funcionamento do jogo.

### Design Pattern
Para este efeito, decidimos implementar o *State Pattern*, com umas pequenas alterações: dada a necessidade de voltar a estados anteriores, implementámos uma *stack* no Game com os diferentes estados, sendo assim o state ativo aquele que se encontra no topo da mesma. Para podermos implementar os diferentes states, usámos generics, de modo a que estes suportem diferentes models.

### Implementação
<p align = "center">
  <img width = 650 src = "images/uml/stateGame.svg">
</p>

### Consequências
- preservação do Single Responsability Principle: cada state tem a sua classe
- preservação o Open-Closed Principle: a adição de novos states não afeta os states já existentes
- evasão a *state machines* com condicionais complexos

<br>

## Escolha do desenho das personagens
### Contexto do problema
No nosso jogo, tanto no modo **monocarater** quanto no **multicarater** existe a necessidade de diferenciar os personagens
Apesar do nosso jogo não utilizar uma framework de gráficos complexa, existe a necessidade de diferenciar os inimigos para perceber, por exemplo, que arma utiliazam ou quão fortes são.
Foram estudadas várias soluções para o problema, como por exemplo utilizar uma subclasse para cada personagem.

### Design pattern
Para este problema decidimos utilizar uma solução própria. Criámos uma enumeração que contem os tipos de inimigos que podem existir esta enumeração está armazenada na classe **Enemy**. 
Para suportar esta forma de desenhar os inimigos cada **Viewer** terá um mapa que, para cada tipo de inimigo retorna a forma de o desenhar naquele **Viewer**.

### Implementação 
<p align = "center">
  <img width = 650 src = "images/uml/draw.svg">
</p>


### Consequências
- Existe uma pequena violação do Open-Closed Principle, porque ao criar novos tipos de inimigos teriamos de alterar os viewers para os conseguir desenhar. No entanto, esta alternativa revelou ser a melhor entre todas as outras que considerámos
- Permite ter diferentes formas de desenhar os inimigos consoante o viewer que está a ser chamado


## Estados distintos - Gráficos diferentes
### Contexto do problema
O nosso jogo, como foi explicado anteriormente, pode ser dividido em vários estados. Em alguns, os requerimentos para a qualidade dos gráficos são diferentes: no estado Wander, semelhante à arena do hero, o tamanho dos componentes da cena permite que sejam representados apenas por simples carateres (chamemos a gráficos como estes **monocarater**); no entanto, no estado de batalha, consideramos que existe a necessidade de formar imagens de maior qualidade e formadas por vários carateres (designaremos estes gráficos como **multicarater**). Também havia a questão de como tornar estes dois estilos de gráficos diferentes minimamente agradáveis. 

### Solução
Decidimos que a melhor opção seria que o tamanho da letra e a resolução do terminal não poderiam ser as mesmas. Por esta razão, optámos por gerar um novo terminal no caso de entrada num modo que assim o necessite, com resolução e tamanho diferentes. Quanto à segunda fase do problema, e devido às limitações impostas pelo terminal a utilizar optámos por:
- recorrer ao uso de custom fonts para melhorar os gráficos **monocarater**
- formular imagens em formato ascii art através de conversores online no que toca aos gráficos **multicarater**. Escolhemos esta opção tendo em conta a sua relativa simplicidade mas decente qualidade.


## Group Renderers
### Contexto do problema
No modo de batalha, o desenho dos elementos da cena é mais complicado, dado que cada compomente é prefeito por múltiplos carateres. Para isto, foi criada a familia de classes **Renderer**. Um **SpriteRenderer** constrói um mapa de carateres e posições. Existem vezes em que queremos que o elemento represente apenas uma imagem, mas outras em que pretendemos que o elemento represente várias imagens. No entanto, seria desejável que o viwer responsável por desenhar os componentes da cena não tivesse que distinguir entre estes. 

### Design Pattern
Como solução para este problema foi implementado um Composite. Existe, então, uma classe **GroupRenderer** que contém uma list de renderers.

### Implementação
<p align = "center">
  <img width = 650 src = "images/uml/rendererComposite.svg">
</p>

### Consequeências
- Simplifica o cliente, neste caso, a classe **BattleViewer**

## Menu - Opções disponíveis para o utilizador
### Contexto do problema
No nosso programa, cada opção deve conter um índice, uma palavra ou frase curta a descrever a opção e ainda uma ação associada se estiver disponível.

### Design Pattern
Para resolver este problema cada model do menu deve ter um *enum* com as opções válidas para esse menu. No entanto um simples *enum* de Java não se mostrou suficiente porque um enum não contém indice nem a string para armazenar a pequena descrição de cada opção. Para colmatar essa limitação extendemos a classe *enum* para que contenha a string e indice necessários. <br>Para representar uma ação a cada opção foi utilizado o ***Command Pattern***. Cada controller tem, consoante a sua necessidade, a sua própria interface que representa o *command*. Para associar um *command* a uma opção foi utilizado um mapa que faz a correspondencia entre a opção e o seu command. <br>Por fim, do ponto de vista do viewer, apenas é necessario consultar o *model* para obter a opção selecionada e cada opção contém como foi dito anteriormente a sua descrição.

### Implementação
O Java não permite o *override* de métodos *static* portanto não foi possivel generalizar a interface dos *enums* utilizados, uma vez que, os métodos adicionados devem ser static. Por isso apenas foi apresentado o UML de um menu que é bastante semelhante a todos os outros menus.
<p align = "center">
  <img width = 650 src = "images/uml/optionMenu.svg">
</p>

### Consequencias
 - Permite manter facilmente a integridade dos menus do jogo, uma vez que, toda a informação sobre cada opção se encontra centralizada
 - Ao testar o OptionMenuController testamos a generalidade dos menus do jogo
 - Os comandos são representados por classes o que simplifica os métodos de execução de comandos e permite evitar o code smell ***Switch Statements***