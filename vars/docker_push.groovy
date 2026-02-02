def call(String imageName, String tag, String dockerUser = "shivamnegi07") {

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubCred',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh """
          echo "\$DOCKER_PASS" | docker login -u "\$DOCKER_USER" --password-stdin
          docker tag ${imageName}:${tag} ${dockerUser}/${imageName}:${tag}
          docker push ${dockerUser}/${imageName}:${tag}
        """
    }
}
