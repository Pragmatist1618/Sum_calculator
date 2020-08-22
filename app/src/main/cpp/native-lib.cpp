#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */,
        jint val1,
        jint val2) {
    std::string hello = std::to_string(val1 + val2);
    return env->NewStringUTF(hello.c_str());
}
