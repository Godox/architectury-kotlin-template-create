repositories {
    // mavens for Create Fabric and dependencies
    maven("https://mvn.devos.one/releases") // Porting Lib releases
    maven("https://mvn.devos.one/snapshots") // Create and several dependencies
    maven("https://maven.jamieswhiteshirt.com/libs-release") // Reach Entity Attributes
    maven("https://raw.githubusercontent.com/Fuzss/modresources/main/maven") // Forge Config API Port

    maven("https://jitpack.io/") { content { includeGroupAndSubgroups("com.github") } } // Fabric ASM for Porting Lib

    maven("https://maven.shedaniel.me") // Cloth Config, REI
    maven("https://maven.blamejared.com") // JEI

    maven("https://api.modrinth.com/maven") // LazyDFU
    maven("https://maven.terraformersmc.com/releases") // Mod Menu, EMI
}

architectury {
    common(rootProject.property("enabled_platforms").toString().split(","))
}

loom {
    accessWidenerPath.set(file("src/main/resources/examplemod.accesswidener"))
}

dependencies {
    // We depend on fabric loader here to use the fabric @Environment annotations and get the mixin dependencies
    // Do NOT use other classes from fabric loader
    modImplementation("net.fabricmc:fabric-loader:${rootProject.property("fabric_loader_version")}")
    // Remove the next line if you don't want to depend on the API
    modApi("dev.architectury:architectury:${rootProject.property("architectury_version")}")

    modCompileOnly("com.simibubi.create:create-fabric-${rootProject.property("minecraft_version")}:${rootProject.property("create_fabric_version")}")
}