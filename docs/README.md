# LPOO - Fallout: A post pandemic RPG

## Tabela de Conteúdos
(Vai ser o índice)

## Design
### Atributos
#### Contexto do Problema
Tanto o nosso personagem quanto os monstros que enfrentará terão atributos que governarão a aptidão para o combate, a capacide de auto-cura, etc.
Estes atributos também serão partilhados com as armas, que poderão exigir um valor mínimo para serem manuseadas.

#### _Design Pattern_
Numa primeira abordagem ao problema, pensámos utilizar o _design pattern_ Decorator para resolver o problema. Utilizando este _design pattern_ teríamos armas base (sem qualquer atributo) e iríamos adicionando novos comportamentos como remover atributos ou exigir um atributo mínimo ao utilizador da arma. No entanto esta abordagem tem como fragilidade o facto de gerar código muito complexo para um problema simples. Para além disso, como os monstros e a personagem podem ter atributos diferentes, a classe _wrapper_ teria de estar ciente de que atributos possuia a classe que estava a modificar violando o _Open–closed principle_ porque ao modifica-los nos personagens teríamos de modificar os _wrappers_.
A segunda abordagem, foi criar uma classe **_Attributes_** que irá ter todos os atributos que os personagens podem possuir e que as armas podem modificar. Se uma arma não modificar um atributo ou o personagem não tiver um atributo, o seu valor é simplesmente zero.
#### Implementação
<p align="center">
  <img width=650 src="images/attributes.svg">
</p>
