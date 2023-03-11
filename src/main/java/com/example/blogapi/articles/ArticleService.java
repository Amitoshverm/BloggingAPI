package com.example.blogapi.articles;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public ArticleService(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    public ArticleResponseDTO createArticle(createArticleDTO createArticleDTO) {
        var newArticle = modelMapper.map(createArticleDTO, ArticleEntity.class);
        var savedArticle = articleRepository.save(newArticle);
        var articleResponseDto = modelMapper.map(savedArticle,ArticleResponseDTO.class);
        return articleResponseDto;
    }

}
