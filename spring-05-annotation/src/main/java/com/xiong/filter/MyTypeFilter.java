package com.xiong.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    /**
     * @param metadataReader        读取当前正在扫描的类的信息
     * @param metadataReaderFactory 获取其它任何类信息
     * @return true表示包含该类, false表示不包含
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
//        获取注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//        获取类信息
        ClassMetadata metadata = metadataReader.getClassMetadata();
//        获取类资源信息, 即类的文件路径信息
        Resource resource = metadataReader.getResource();
        String className = metadata.getClassName();
        return className.contains("er");
    }
}
