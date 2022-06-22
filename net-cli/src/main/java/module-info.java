module org.d7z.cli {
    requires kotlin.reflect;
    requires kotlin.stdlib;
    requires org.d7z.net.connect.core;
    opens org.d7z.cli;
    exports org.d7z.cli;
}
