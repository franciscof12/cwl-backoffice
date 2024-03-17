import Image from 'next/image'
import Link from 'next/link'

export default function SideNav() {
    return (
        <>
            <div className='pb-14 pl-2 pt-4 justify-start items-center flex'>
            <Image
                src="/trovit_white.png"
                width={85}
                height={85}
                alt="Picture of the trovit logo"
            />
            </div>
            <ul>
                <li>
                    <Link href="/dashboard" className="text-color-ui-crema_white text-xl pb-10 pl-2">
                        Dashboard
                    </Link>
                </li>
                <li>
                    <Link href="/dashboard/sources" className="text-color-ui-crema_white text-xl pb-10 pl-2">
                        Sources Content
                    </Link>
                </li>
                <li>
                    <Link href="/dashboard/blocked" className="text-color-ui-crema_white text-xl pb-10 pl-2">
                        Blocked Sourcesx
                    </Link>
                </li>
            </ul>
            <div className="absolute bottom-0 p-4 gap-2 flex flex-col">
                <a href="/logout" className="text-color-ui-crema_white text-xl">log out</a>
            </div>
        </>
    )
}
