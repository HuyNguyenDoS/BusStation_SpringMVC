/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service.impl;

import com.btl.pojos.Bus;
import com.btl.pojos.Comment;
import com.btl.pojos.User;
import com.btl.repository.BusRepository;
import com.btl.repository.CommentRepository;
import com.btl.repository.UserRepository;
import com.btl.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public long totalItem(int idBus) {
        return this.commentRepository.totalItem(idBus);
    }

    @Override
    public Comment addComment(String content, int idBus, int id) {
        Bus b = this.busRepository.findById(idBus);
        User u = this.userRepository.findById(id);

        Comment c = new Comment();
        if (content == "" || content == null) {
            c.setContent(".");
        } else {
            c.setContent(content);
        }
        c.setUser(u);
        c.setBus(b);
        c.setCreateDate(new Date());
        return this.commentRepository.addComment(c, id);
    }

    @Override
    public List<Object[]> getListComment(int idBus, int page) {
        return this.commentRepository.getListComment(idBus, page);
    }

    @Override
    public List<Comment> getCommentsByidBus(int id, int page) {
        return this.commentRepository.getCommentsByidBus(id, page);
    }

    @Override
    public Comment addComment(String content, int idBus) {
        User u = this.userRepository.getUserByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        Comment c = new Comment();

        c.setContent(content);
        c.setBus(this.busRepository.findById(idBus));
        c.setUser(u);
        c.setCreateDate(new Date());

        return this.commentRepository.addComment(c);
    }

}
