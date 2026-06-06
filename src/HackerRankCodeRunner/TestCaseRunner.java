// TestCaseRunner.java
package HackerRankCodeRunner;

import HackerRankCodeRunner.Problems.HackerRankSolution;
import HackerRankCodeRunner.Problems.IHackerRankSolution;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class TestCaseRunner {

    private final IHackerRankSolution solution;
    private final String inputDir;
    private final String outputDir;

    public TestCaseRunner(IHackerRankSolution solution, String inputDir, String outputDir) {
        this.solution  = solution;
        this.inputDir  = inputDir;
        this.outputDir = outputDir;
    }

    public TestCaseRunner(IHackerRankSolution solution, String testCaseDirectoryPath) {
        this.solution  = solution;
        this.inputDir  = testCaseDirectoryPath;
        this.outputDir = testCaseDirectoryPath;
    }

    /** Convenience constructor using default testcase folder layout */
    public TestCaseRunner(HackerRankSolution solution) {
        this(solution, solution.getTestCasesDirectoryPath());
    }

    public void runAll() throws IOException {
        int passed = 0, failed = 0, total = 0;

        int testCount;
        try (Stream<Path> files = Files.list(Paths.get(inputDir))) {
            testCount = (int) files
                    .filter(p -> p.getFileName().toString().matches("input\\d+\\.txt"))
                    .count();
        } catch (IOException e) {
            System.out.println("Could not read directory: " + e.getMessage());
            return;
        }


        for (int i = 0; i < testCount; i++) {
            String tag = String.format("%03d", i);
            Path inputFile  = Paths.get(inputDir,  "input"  + tag + ".txt");
            Path outputFile = Paths.get(outputDir, "output" + tag + ".txt");


            if (!Files.exists(inputFile))
            {
                System.out.println("Unable to find file");
                System.out.println("Input File Path: "+inputFile );
                System.out.println("Output File Path: "+outputFile );
                continue;
            }
            total++;

            String       rawInput = Files.readString(inputFile);
            Scanner      sc       = new Scanner(rawInput);
            StringWriter sw       = new StringWriter();
            PrintWriter  pw       = new PrintWriter(sw);

            try {
                solution.solve(sc, pw);  // ← delegates to whatever was injected
            } catch (Exception e) {
                System.out.printf("❌ Test %s — EXCEPTION: %s%n", tag, e.getMessage());
                System.out.println("   Input was:");
                printIndented(rawInput);
                failed++;
                continue;
            }
            pw.flush();

            String actual   = normalize(sw.toString());
            String expected = Files.exists(outputFile)
                    ? normalize(Files.readString(outputFile))
                    : null;

            if (expected == null) {
                System.out.printf("⚠️  Test %s — no expected output file found%n", tag);
                System.out.println("   Your output:");
                printIndented(sw.toString());
            } else if (actual.equals(expected)) {
                System.out.printf("✅ Test %s — PASSED%n", tag);
                passed++;
            } else {
                System.out.printf("❌ Test %s — FAILED%n", tag);
                System.out.println("   ── Input ──────────────────────────");
                printIndented(rawInput);
                System.out.println("   ── Expected ───────────────────────");
                printIndented(expected);
                System.out.println("   ── Got ────────────────────────────");
                printIndented(actual);
                failed++;
            }
        }

        System.out.println();
        System.out.printf("Results: %d/%d passed \n", passed, total);
        if (failed > 0) System.out.printf(", %d failed", failed);
        System.out.println();
    }

    private  String normalize(String s) {
        return Arrays.stream(s.split("\\r?\\n"))
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    private  void printIndented(String s) {
        Arrays.stream(s.split("\\r?\\n"))
                .forEach(line -> System.out.println("      " + line));
    }
}