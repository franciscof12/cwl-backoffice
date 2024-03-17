import Image from 'next/image'

export default function Header() {
    return (
            <nav className="justify-end items-center flex gap-4 text-color-ui-crema_black">
                <div className='flex-row flex gap-2 justify-normal items-center'>
                <Image
                src="/golangicon.png"
                width={35}
                height={35}
                alt="Picture of the trovit logo"
                className=' rounded-full'
                />
                <p className='text-base font-semibold'>Francisco Ferreira</p>
                </div>
            </nav>
    )
}