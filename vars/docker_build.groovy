def call(Map config) {
    if (!config.image) {
        error "Image name is required"
    }

    def tag = config.tag ?: "latest"

    sh "docker build -t ${config.image}:${tag} ."
}
