package com.ivankara.covid19selfcheck.tests.logic;

import androidx.databinding.Observable;
import androidx.databinding.library.baseAdapters.BR;

import com.ivankara.covid19selfcheck.logic.MainViewModel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MainViewModelTest {
    MainViewModel _vm;

    public MainViewModelTest() {
        _vm = new MainViewModel();
    }

    @Test
    public void questionTitle_test() {
        // Event handler.
        final int[] count = {0};
        _vm.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.questionTitle) {
                    ++count[0];
                }
            }
        });

        // Test.
        _vm.setQuestionTitle("test");

        // Assert.
        assertEquals("test", _vm.getQuestionTitle());
        _vm.setQuestionTitle(null);
        assertEquals(2, count[0]);
    }

    @Test
    public void conclusionTitle_test() {
        // Event handler.
        final int[] count = {0};
        _vm.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.conclusionTitle) {
                    ++count[0];
                }
            }
        });

        // Test.
        _vm.setConclusionTitle("test");

        // Assert.
        assertEquals("test", _vm.getConclusionTitle());
        _vm.setConclusionTitle(null);
        assertEquals(2, count[0]);
    }

    @Test
    public void start_test() {
        // Event handler.
        final int[] count = {0};
        _vm.setStartedListener(() -> ++count[0]);

        // Test.
        _vm.start();

        // Assert.
        assertNull(_vm.getConclusionTitle());
        assertEquals("q1", _vm.getQuestionTitle());
        assertEquals(1, count[0]);
    }

    @Test
    public void reset_test() {
        // Event handler.
        final int[] count = {0};
        _vm.setResetRequestedListener(() -> ++count[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.reset();
        _vm.start();

        // Assert.
        assertNull(_vm.getConclusionTitle());
        assertEquals("q1", _vm.getQuestionTitle());
        assertEquals(1, count[0]);
    }

    @Test
    public void closeApp() {
        // Event handler.
        final int[] count = {0};
        _vm.setCloseRequestedListener(() -> ++count[0]);

        // Test.
        _vm.closeApp();

        // Assert.
        assertEquals(1, count[0]);
    }

    @Test
    public void answer_test1() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(true);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q1", _vm.getQuestionTitle());
        assertEquals("con_danger", _vm.getConclusionTitle());
    }

    @Test
    public void answer_test1_2() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);

        // Assert.
        assertEquals(0, concludeCount[0]);
        assertEquals("q2", _vm.getQuestionTitle());
        assertNull(_vm.getConclusionTitle());
    }

    @Test
    public void answer_test2() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(true);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q2", _vm.getQuestionTitle());
        assertEquals("con_danger", _vm.getConclusionTitle());
    }

    @Test
    public void answer_test2_2() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);

        // Assert.
        assertEquals(0, concludeCount[0]);
        assertEquals("q3", _vm.getQuestionTitle());
        assertNull(_vm.getConclusionTitle());
    }

    @Test
    public void answer_test3() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);

        // Assert.
        assertEquals(0, concludeCount[0]);
        assertEquals("q4", _vm.getQuestionTitle());
        assertNull(_vm.getConclusionTitle());
    }

    @Test
    public void answer_test3_2() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);

        // Assert.
        assertEquals(0, concludeCount[0]);
        assertEquals("q4", _vm.getQuestionTitle());
        assertNull(_vm.getConclusionTitle());
    }

    @Test
    public void answer_test4() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q4", _vm.getQuestionTitle());
        assertEquals("con_isolate", _vm.getConclusionTitle());
    }

    @Test
    public void answer_test4_2() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);
        _vm.answer(true);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q4", _vm.getQuestionTitle());
        assertEquals("con_isolate", _vm.getConclusionTitle());
    }

    @Test
    public void answer_test4_3() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);

        // Assert.
        assertEquals(0, concludeCount[0]);
        assertEquals("q5", _vm.getQuestionTitle());
        assertNull(_vm.getConclusionTitle());
    }

    @Test
    public void answer_test5() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q5", _vm.getQuestionTitle());
        assertEquals("con_isolate", _vm.getConclusionTitle());
    }

    @Test
    public void answer_test5_2() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);
        _vm.answer(false);
        _vm.answer(true);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q5", _vm.getQuestionTitle());
        assertEquals("con_isolate", _vm.getConclusionTitle());
    }

    @Test
    public void answer_test5_3() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);
        _vm.answer(false);
        _vm.answer(false);

        // Assert.
        assertEquals(0, concludeCount[0]);
        assertEquals("q6", _vm.getQuestionTitle());
        assertNull(_vm.getConclusionTitle());
    }

    @Test
    public void answer_test5_4() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);

        // Assert.
        assertEquals(0, concludeCount[0]);
        assertEquals("q6", _vm.getQuestionTitle());
        assertNull(_vm.getConclusionTitle());
    }

    @Test
    public void answer_test6() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q6", _vm.getQuestionTitle());
        assertEquals("con_good", _vm.getConclusionTitle());
    }

    @Test
    public void answer_test6_2() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q6", _vm.getQuestionTitle());
        assertEquals("con_isolate", _vm.getConclusionTitle());
    }

    @Test
    public void answer_test6_3() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(false);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q6", _vm.getQuestionTitle());
        assertEquals("con_good", _vm.getConclusionTitle());
    }

    @Test
    public void answer_test6_4() {
        // Event handler.
        final int[] concludeCount = {0};
        _vm.setConclusionMadeListener(() -> ++concludeCount[0]);

        // Test.
        _vm.start();
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);
        _vm.answer(false);
        _vm.answer(false);
        _vm.answer(true);

        // Assert.
        assertEquals(1, concludeCount[0]);
        assertEquals("q6", _vm.getQuestionTitle());
        assertEquals("con_isolate", _vm.getConclusionTitle());
    }
}
