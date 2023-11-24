document.getElementById("formLogin").addEventListener("submit", function (event) {
    event.preventDefault();

    var email = document.getElementById("email").value;
    var senha = document.getElementById("password").value;

    var loginData = {
        email_usuario: email,
        senha_usuario: senha
    };

    if (!email || !senha) {
        console.error("Erro: Um ou mais elementos não foram encontrados.");
        return;
    }

    axios.post("http://localhost:6789/login/get", loginData)
        .then((response) => {
           
        window.location.href = "index.html";
           
        })
        .catch((error) => {
            console.error("Erro ao enviar requisição:", error);
            // Exibir a mensagem de erro
            document.getElementById("error-message").textContent = "Usuário não Existente";
        });
});
