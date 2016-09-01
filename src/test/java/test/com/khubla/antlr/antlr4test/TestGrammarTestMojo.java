/*
 [The "BSD license"]
 Copyright (c) 2014 Tom Everett
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package test.com.khubla.antlr.antlr4test;

import java.io.File;
import java.net.URL;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import com.khubla.antlr.antlr4test.GrammarTestMojo;

/**
 * @author Tom Everett
 */
public class TestGrammarTestMojo extends AbstractMojoTestCase {
   /**
    * file
    */
   private static final String POMFILE = "src/test/resources/GrammarTestMojo-pom.xml";
   /**
    * goal
    */
   private static final String GOAL = "test";

   @Override
   protected void setUp() throws Exception {
      // required
      super.setUp();
   }

   @Override
   protected void tearDown() throws Exception {
      // required
      super.tearDown();
   }

   /**
    * Basic test of execution
    */
   public void testExecution() throws Exception {
         final File pom = getTestFile(POMFILE);
         assertNotNull(pom);
         assertTrue(pom.exists());
         final GrammarTestMojo grammarTestMojo = (GrammarTestMojo) lookupMojo(GOAL, pom);
         assertNotNull(grammarTestMojo);
         grammarTestMojo.setBaseDir(new File(getAbsolutePath("../..")).getCanonicalFile());
         grammarTestMojo.execute();
   }

   /**
    * Basic test of instantiation
    */
   public void testInstatiation() throws Exception {
         final File pom = getTestFile(POMFILE);
         assertNotNull(pom);
         assertTrue(pom.exists());
         final GrammarTestMojo grammarTestMojo = (GrammarTestMojo) lookupMojo(GOAL, pom);
         assertNotNull(grammarTestMojo);
         assertTrue(grammarTestMojo.isVerbose() == true);
         assertTrue(grammarTestMojo.getExampleFiles().compareTo("src/test/resources/examples/") == 0);
         assertTrue(grammarTestMojo.getEntryPoint().compareTo("equation") == 0);
   }

   protected String getAbsolutePath(String relativePath) {
      final ClassLoader classLoader = getClass().getClassLoader();
      final URL resource = classLoader.getResource(".");
      final File file = new File(resource.getFile(), relativePath);
      return file.getAbsolutePath();
   }

}