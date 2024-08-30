package com.univocity.parsers.common.iterators;

import com.univocity.parsers.common.*;
import com.univocity.parsers.common.record.*;

/**
 * An {@code iterator} over the parser results returning them as {@code Records}
 *
 * This does not allow the {@code input} to be re-parsed by the {@code parser}
 * and so can not be iterated over more than once.
 * Will throw an {@link IllegalStateException} if it is attempted.
 *
 * @author uniVocity Software Pty Ltd - <a href="mailto:dev@univocity.com">dev@univocity.com</a>
 */
public abstract class ParserRecordIterator extends ParserIterable<Record> {

	protected boolean startedParser;
	protected boolean parserHasRan;

	/**
	 * Creates a {@code ParserRecordIterator} using the provided {@code parser}
	 *
	 * @param parser the {@code parser} to iterate over
	 */
	protected ParserRecordIterator(AbstractParser parser) {
		super(parser);
	}

	/**
	 * This method is called whenever the {@code iterator} is starting to iterate over the
	 * results.
	 * an example implementation of this is:
	 * <hr>
	 * <pre>
	 *     {@code
	 *     @literal @Override
	 *     public void beginParsing(){
	 *         parser.beginParsing(input);
	 *     }}
	 * </pre>
	 * <hr>
	 * This is to allow for different input types such as {@code Reader, File, or InputStream} without large code
	 * reuse.
	 */
	protected abstract void beginParsing();

	@Override
	public ResultIterator<Record, ParsingContext> iterator() {
		return new ResultIterator<Record, ParsingContext>() {
			@Override
			public ParsingContext getContext() {
				return ParserRecordIterator.super.getContext();
			}

			@Override
			public boolean hasNext() {
				if (!startedParser) {
					beginParsing();
					startedParser = true;
				}
				if (getContext().isStopped()) {
					if (!parserHasRan) {
						parserHasRan = true;
					} else {
						throw new IllegalStateException("The input object has been automatically closed and can't be reparsed.");
					}
					return false;
				}
				return true;
			}

			@Override
			public Record next() {
				return parser.parseNextRecord();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Can't remove record");
			}
		};
	}
}
