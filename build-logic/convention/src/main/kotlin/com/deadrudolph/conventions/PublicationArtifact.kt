package com.deadrudolph.conventions

import org.gradle.api.publish.maven.MavenPublication

data class PublicationArtifact(
    val publicationName: String,
    val artifactId: String,
    val artifactProvider: MavenPublication.() -> Unit,
)
