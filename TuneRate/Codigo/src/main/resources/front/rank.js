  // Função para embaralhar o array
  function shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
  }

  // Função para carregar o JSON e exibir as músicas
  async function carregarEMostrarMusicas() {
    try {
      // Carregar o arquivo JSON
      const resposta = await fetch('musicas.json');
      const musicas = await resposta.json();

      // Embaralhar o array de músicas
      shuffleArray(musicas);

      // Selecionar as 10 primeiras músicas
      const top10Musicas = musicas.slice(0, 10);

      // Criar linhas da tabela dinamicamente
      const tabela = document.getElementById('musicTable').getElementsByTagName('tbody')[0];
      top10Musicas.forEach(musica => {
        const row = tabela.insertRow();
        const cell1 = row.insertCell(0);
        const cell2 = row.insertCell(1);
        const cell3 = row.insertCell(2);
        const cell4 = row.insertCell(3);
        cell1.textContent = musica.musica;
        cell2.textContent = musica.cantor;
        cell3.textContent = musica.genero;
        cell4.textContent = musica.bpm;
      });
    } catch (erro) {
      console.error('Erro ao carregar ou exibir músicas:', erro);
    }
  }

  // Função para filtrar músicas por gênero
 async function filtrarPorGenero() {
    try {
        // Carregar o arquivo JSON
        const resposta = await fetch('musicas.json');
        const musicas = await resposta.json();
  
    const generoSelecionado = document.getElementById('genero').value;
    const tabela = document.getElementById('musicTable').getElementsByTagName('tbody')[0];
    tabela.innerHTML = ''; // Limpar a tabela

    // Filtrar e exibir as músicas do gênero selecionado
    const musicasFiltradas = musicas.filter(musica => musica.genero == generoSelecionado);
    const top10MusicasFiltradas = musicasFiltradas.slice(0, 10);

    // Criar linhas da tabela dinamicamente
    top10MusicasFiltradas.forEach(musica => {
      const row = tabela.insertRow();
      const cell1 = row.insertCell(0);
      const cell2 = row.insertCell(1);
      const cell3 = row.insertCell(2);
      const cell4 = row.insertCell(3);
      cell1.textContent = musica.musica;
      cell2.textContent = musica.cantor;
      cell3.textContent = musica.genero;
      cell4.textContent = musica.bpm;
    });
} catch (erro) {
    console.error('Erro ao carregar ou exibir músicas:', erro);
  }
  }

  // Chamar a função ao carregar a página
  carregarEMostrarMusicas();