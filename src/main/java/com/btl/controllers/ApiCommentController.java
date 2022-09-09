/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btl.controllers;

import com.btl.pojos.Comment;
import com.btl.service.CommentService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiCommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/api/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params) {
        try {
            String content = params.getOrDefault("content", "");
            int busId = Integer.parseInt(params.get("idBus"));
            Comment c = this.commentService.addComment(content, busId);

            return new ResponseEntity<>(c, HttpStatus.CREATED);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
