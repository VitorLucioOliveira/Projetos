class Heroi {
  constructor(nome, idade, tipo) {
    this.nome = nome;
    this.idade = idade;
    this.tipo = tipo;
  }

  ataque(tipo) {
    switch (tipo) {
      case "mago":
        return "magia";
      case "guerreiro":
        return "espada";
      case "monge":
        return "artes marciais";
      case "ninja":
        return "shuriken";
    }
  }

  atacar() {
    console.log(`O ${this.tipo} atacou usando ${this.ataque(this.tipo)}!`);
  }
}


const heroi = new Heroi("Aragorn", 35, "guerreiro");
heroi.atacar();