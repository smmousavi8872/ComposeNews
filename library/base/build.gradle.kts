plugins {
    id("composenews.android.library")
    id("composenews.android.library.compose")
}

android {
    namespace = "ir.kaaveh.base"
}

dependencies {
    
    api(project(":library:core-test"))
    implementation(project(":library:designsystem"))

    libs.apply {
        implementation(lifecycle.viewmodel.ktx)
    }
}