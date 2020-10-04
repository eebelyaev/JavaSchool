package ru.sberbank.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@TypeAnno
public class AnnotationDemo {
    @AnnoAnno
    @interface Anno {
    }

    @FieldAnno
    String str;

    @ContructorAnno
    AnnotationDemo(@ParamAnno String str) {
        @LocalAnno int x = 5;
        this.str = str + x;
    }

    @MethodAnno
    <@TypeParamAnno T> T method() {
        return null;
    }

}

@Target(ElementType.TYPE)
@interface TypeAnno {
}

@Target(ElementType.ANNOTATION_TYPE)
@interface AnnoAnno {
}

@Target(ElementType.FIELD)
@interface FieldAnno {
}

@Target(ElementType.CONSTRUCTOR)
@interface ContructorAnno {
}

@Target(ElementType.PARAMETER)
@interface ParamAnno {
}

@Target(ElementType.LOCAL_VARIABLE)
@interface LocalAnno {
}

@Target(ElementType.METHOD)
@interface MethodAnno {
}


@Target(ElementType.TYPE_PARAMETER)
@interface TypeParamAnno {
}

