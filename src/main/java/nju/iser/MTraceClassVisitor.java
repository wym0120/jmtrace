package nju.iser;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MTraceClassVisitor extends ClassVisitor {
    public MTraceClassVisitor(int i) {
        super(i);
    }


    public MTraceClassVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
        return new MTraceInstVisitor(Opcodes.ASM9, mv);
    }


}
