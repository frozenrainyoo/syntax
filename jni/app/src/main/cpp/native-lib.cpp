#include <jni.h>
#include <string>
#include <android/log.h>
// reference url
// https://yalantis.com/blog/android-ndk-calling-kotlin-from-native-code/

struct App {
    JNIEnv *env;
    jobject javaObject;
    jmethodID javaMethodID_test;
};

class JNIApp {
public:
    JNIApp(JNIEnv *env, jobject object);
    void CallTest();
private:
    App* app;
};

JNIApp::JNIApp(JNIEnv *env, jobject object) {
    app = new App();
    app->env = env;
    app->javaObject = env->NewGlobalRef(object);
    jclass javaClass = env->GetObjectClass(object);
    app->javaMethodID_test = env->GetMethodID(javaClass, "callTestFromCPP", "()V");
}

void JNIApp::CallTest() {
    if (app->javaMethodID_test == NULL) {
        __android_log_print(ANDROID_LOG_DEBUG, "test", "%s javaMethodID is null", __func__);
        return;
    }

    app->env->CallVoidMethod(app->javaObject, app->javaMethodID_test);
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_frozenrain_jni_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT void JNICALL
Java_com_example_frozenrain_jni_MainActivity_showStringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    __android_log_print(ANDROID_LOG_DEBUG, "test", "%s", __func__);

    jclass javaClass = env->FindClass("com/example/frozenrain/jni/MainActivity");
    jmethodID javaMethodID = env->GetStaticMethodID(javaClass, "showStringFromCPP", "()V");
    if (javaMethodID == NULL) {
        __android_log_print(ANDROID_LOG_DEBUG, "test", "%s javaMethodID is null", __func__);
        return;
    }

    env->CallStaticVoidMethod(javaClass,javaMethodID);
}

extern "C" JNIEXPORT jlong JNICALL
        Java_com_example_frozenrain_jni_MainActivity_init(
                JNIEnv *env,
                jobject object) {
    JNIApp* app = new JNIApp(env, object);
    return (jlong)app;
}

extern "C" JNIEXPORT void JNICALL
Java_com_example_frozenrain_jni_MainActivity_callTest(
        JNIEnv *env,
        jobject object,
        jlong p) {
    JNIApp* app = reinterpret_cast<JNIApp*>(p);
    app->CallTest();
}