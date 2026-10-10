plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "uottawa.seg2505"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "uottawa.seg2505"
        minSdk = 30
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Bibliothèques déjà présentes
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // Room : base de données SQLite
    implementation("androidx.room:room-runtime:2.6.1")

    // Génération du code Room pour Java
    annotationProcessor("androidx.room:room-compiler:2.6.1")

    // LiveData : observation des données
    implementation("androidx.lifecycle:lifecycle-livedata:2.8.7")

    // ViewModel : gestion des données de l'interface
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.7")

    // RecyclerView : affichage de la liste
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}