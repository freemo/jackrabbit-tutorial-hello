package com.syncleus.tutorial.jackrabbit.hello;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.core.TransientRepository;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static final String MESSAGE = "Hello, World!";

    public void testHelloWorld() throws RepositoryException
    {
    	Repository repo = new TransientRepository();
    	Session session = repo.login(
    			new SimpleCredentials("admin","admin".toCharArray()));
    	try {
            Node root = session.getRootNode();

            // Store content 
            Node hello = root.addNode("hello"); 
            Node world = hello.addNode("world"); 
            world.setProperty("message", MESSAGE);
            session.save(); 

            // Retrieve content 
            Node node = root.getNode("hello/world");
            Assert.assertEquals(MESSAGE, node.getProperty("message").getString());

            // Remove content 
            root.getNode("hello").remove(); 
            session.save(); 
    	}
        finally {
            session.logout();
        }
    }
}
