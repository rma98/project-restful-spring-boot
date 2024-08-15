package br.edu.ifpe.gerenciadorSalas.dto;

public class AuthResponse {
    private String message;
    private String token; // Inclua o token se estiver usando autenticação baseada em token

    public AuthResponse(String message) {
        this.message = message;
    }

    public AuthResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    // Getters e Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
