/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.service;

import com.btl.pojos.Comment;
import java.util.List;

public interface CommentService {

    long totalItem(int idBus);

    Comment addComment(String contentString, int idBus, int id);

    List<Object[]> getListComment(int idBus, int page);

    List<Comment> getCommentsByidBus(int id, int page);

    Comment addComment(String content, int idBus);
}
