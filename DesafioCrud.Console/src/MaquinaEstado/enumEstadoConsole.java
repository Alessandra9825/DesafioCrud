package MaquinaEstado;

public enum enumEstadoConsole {
    ATUALIZAR(new EstadoConsoleAtualizar()),
    BEM_VINDO(new EstadoConsoleBemVindo()),
    CONSULTAR(new EstadoConsoleConsultar()),
    DELETE(new EstadoConsoleDelete()),
    HOME(new EstadoConsoleHome()),
    LOGIN(new EstadoConsoleLogin()),
    SALVAR(new EstadoConsoleSalvar());

    private final MaquinaEstadoConsole estadoMaquina;

    enumEstadoConsole(MaquinaEstadoConsole estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }


    public MaquinaEstadoConsole getEstadoConsole() {
        return estadoMaquina;
    }
}
