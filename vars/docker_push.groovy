def call(Map config) {
    sh """
      docker tag ${config.image}:${config.tag} ${config.repo}/${config.image}:${config.tag}
      docker push ${config.repo}/${config.image}:${config.tag}
    """
}
