package com.moriartynho.BazarNovaVida.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moriartynho.BazarNovaVida.models.itens.imagem.Imagem;
import com.moriartynho.BazarNovaVida.repositories.ImagemRepository;

@Service
public class ImagemService {
    @Autowired
    private ImagemRepository imagemRepository;
    
    public void salvarImagem(MultipartFile file) throws IOException {
        byte[] dados = file.getBytes();
        
        Imagem imagem = new Imagem();
        imagem.setDados(dados);
        
        imagemRepository.save(imagem);
    }
}
