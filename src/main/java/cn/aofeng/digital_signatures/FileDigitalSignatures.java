/**
 * 建立时间:2008-11-4
 */
package cn.aofeng.digital_signatures;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;

import cn.aofeng.util.EncryptCodeUtils;
import cn.aofeng.util.ProgressInfo;
import cn.aofeng.util.Visitor;

/**
 * 文件数字签名摘要.
 * 
 * @author 聂勇 <a href="mailto:aofengblog@163.com>aofengblog@163.com</a>
 */
public class FileDigitalSignatures {

	/**
	 * Logger for this class
	 */
	public static final Logger logger = Logger.getLogger(FileDigitalSignatures.class);
	
	private ProgressInfo _progressInfo = new ProgressInfo();
	
	/**
	 * 文件大小(单位:bytes).
	 */
	public float getFilesize() {
		return _progressInfo.getTotalSize();
	}

	/**
	 * 已读取数据量(单位:bytes).
	 */
	public float getReadsize() {
		return _progressInfo.getProcessedSize();
	}
	
	/**
	 * 根据指定的hash类型生成文件内容的hash值.
	 * 
	 * @param filePath 文件完整路径.
	 * @param hashType hash类型:"MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512".
	 * 
	 * @return 文件内容的hash值.
	 * 
	 * @see EncryptCodeUtils#hash(File, String)
	 */
    public String hash(String filePath, String hashType) {
		if (StringUtils.isBlank(filePath) || StringUtils.isBlank(hashType)) {
			throw new IllegalArgumentException("filePath or hashType value is invaild");
		}
		
		File file = new File(filePath);
		
		return EncryptCodeUtils.hash(file, hashType, new ProgressVisitor<ProgressInfo>());
	}
	
	/**
	 * 重置.
	 */
	public void reset() {
	    _progressInfo = new ProgressInfo();
	}
	
//	/**
//	 * @param args 输入参数:<br />
//	 * [0] - hash类型:"MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512"<br />
//	 * [1] - 需计算Hash值的文件完整路径<br />
//	 * [2] - 需比较的Hash值.
//	 */
//	public static void main(String[] args) {
//		if (null == args || args.length != 3) {
//			System.err.println("Illegal arguments, must enter arguments like this:0 - hash type, 1 - file path, 2 - need check hash value. \r\nFor example:java FileDigest MD5 D:/Java/eclipse3.3.2.rar 2dfsf");
//			return;
//		}
//		
//		FileDigest fileDigest = new FileDigest();
//		String hash = fileDigest.hash(args[1], args[0]);
//		
//		if (hash.equalsIgnoreCase(args[2])) {
//			logger.info("hash value is right");
//		} else {
//			logger.warn("enter hash value:" + args[2] + ", but right hash value:" + hash);
//		}
//	}

	class ProgressVisitor<T extends ProgressInfo> implements Visitor<T> {

        @Override
        public void addVisitor(Visitor<T> visitor) {
            throw new IllegalStateException("not yet implements");
        }

        @Override
        public void process(T progressInfo) {
            _progressInfo = progressInfo;
        }
        
	}

}
