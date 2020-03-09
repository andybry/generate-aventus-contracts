lazy val app = (project in file(".")).settings(
    libraryDependencies += "com.github.pureconfig" % "pureconfig_2.12" % "0.12.3",
    libraryDependencies += "org.web3j" % "codegen" % "4.5.16",
    libraryDependencies += "org.web3j" % "core" % "4.5.16"
)