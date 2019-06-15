package net.notjustanna.libs.resources;

import static java.util.Objects.requireNonNull;

class ResourceUtils {
    static <T> T requireNonNullElse(T obj, T defaultObj) {
        return (obj != null) ? obj : requireNonNull(defaultObj, "defaultObj");
    }
}
