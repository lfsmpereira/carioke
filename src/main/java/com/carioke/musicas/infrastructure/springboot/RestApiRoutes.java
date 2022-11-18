package com.carioke.musicas.infrastructure.springboot;

public class RestApiRoutes {
    public static final String API = "/api";

    public static class Compositores {
        public static final String COMPOSITORES = API + "/compositores";
    }

    public static class Interpretes {
        public static final String INTERPRETES = API + "/interpretes";
    }

    public static class Musicas {
        public static final String MUSICAS = API + "/musicas";
        public static final String MUSICAS_COMPOSITORES = MUSICAS + "/compositores";
    }

    public static class Versoes {
        public static final String VERSOES = API + "/versoes";
        public static final String VERSOES_INTERPRETES = VERSOES + "/interpretes";
    }

    public static class Catalogos {
        public static final String CATALOGOS = API + "/catalogos";
        public static final String CATALOGOS_VERSOES = CATALOGOS + "/versoes";
    }

}