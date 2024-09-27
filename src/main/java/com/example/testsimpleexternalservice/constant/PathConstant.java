package com.example.testsimpleexternalservice.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class PathConstant {
    public static final String VERSION = VersionConstant.VERSION_1;
    public static final String API = "/api";
    public static final String SLASH_ID = "/{id}";
    public static final String SLASH = "/";

    @UtilityClass
    public static class CommentPathConstant {
        public static final String BASE_PATH = API + SLASH + VERSION + "/comments";

        public static final String BY_POST_ID = "/by-post-id/{postId}";
    }

    @UtilityClass
    public static class UserPathConstant {
        public static final String BASE_PATH = API +  SLASH + VERSION + "/users";
    }

    @UtilityClass
    public static class PostPathConstant {
        public static final String BASE_PATH = API +  SLASH + VERSION + "/posts";
    }

    @UtilityClass
    public static class FilePathConstant {
        public static final String BASE_PATH = API +  SLASH + VERSION + "/files";
        public static final String SHOW_BY_FILE_NAME = "/show/{fileUniqueName}";
    }

}
